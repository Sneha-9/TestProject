package com.sneha.parkingLot;

import java.util.Objects;

public class ParkingLot {
    private final Floor[] floors;
    private  TimeUtil timeUtil;
    private final Terminal terminal;
    private IdGenerator idGenerator;

    public ParkingLot(IdGenerator idGenerator, TimeUtil timeUtil, Terminal terminal, Floor... floors) {
        if (floors.length == 0) {
            throw new IllegalArgumentException();
        }

        this.floors = floors;
        this.timeUtil = timeUtil;
        this.idGenerator = idGenerator;
        this.terminal = terminal;
    }

    public Ticket parkVehicle(Vehicle vehicle) throws IllegalArgumentException {
        Lot lot = null;
        Floor floor = null;

        for (Floor f : floors) {
            if (f.getAvailableLot() == null) {
                continue;
            }

            if (f.getAvailableLot().isAvailable()) {
                floor = f;

                lot = f.getAvailableLot();
                lot.parkVehicle(vehicle);

                break;
            }
        }
        if (floor == null || lot == null) {
            throw new IllegalArgumentException("Floor or lot cannot be empty");
        }

        return terminal.generateTicket(idGenerator, vehicle, lot, floor);
    }

    public Bill getBill(Ticket ticket) {
        return terminal.generateBill(ticket);
    }

    public Vehicle unPark(Ticket ticket, Bill bill) throws UnpaidBillException, FloorNotFoundException, LotNotFoundException {
        if(bill.isPaid() == false  ){
            throw new UnpaidBillException();
        }

        Floor floor = null;

        for (Floor f : floors) {
            if (Objects.equals(f.getId(), ticket.getFloorId())) {
                floor = f;
                break;
            }
        }
        if(floor == null){
            throw new FloorNotFoundException();
        }
        if(floor.findLot(ticket.getLotId())==null){
            throw new LotNotFoundException();
        }

        Lot lot = floor.findLot(ticket.getLotId());


        return lot.unparkVehicle();
    }


}
