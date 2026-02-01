package com.sneha.parkingLot;

import java.util.Objects;

public class Terminal {
    private final TimeUtil timeUtil;
    private final IdGenerator idGenerator;
    private final String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
    BillGenerationSystem billGenerationSystem;

    Terminal(IdGenerator idGenerator, TimeUtil timeUtil) throws IllegalArgumentException {
        if (idGenerator == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (!idGenerator.generate().matches(regex)) {
            throw new IllegalArgumentException("Id is not valid");
        }
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
        this.billGenerationSystem = new BillGenerationSystem(idGenerator, timeUtil);
    }

    public String getId() {
        return idGenerator.generate();
    }

    Bill generateBill(Ticket ticket) throws IllegalArgumentException {
        return billGenerationSystem.generateBill(ticket);
    }

    Ticket generateTicket(IdGenerator idGenerator, Vehicle vehicle, Lot lot, Floor floor) {
        Ticket ticket = new Ticket(idGenerator, timeUtil, vehicle.getVehicleNumber(), lot.getId(), floor.getId());
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Terminal terminal = (Terminal) o;
        return Objects.equals(timeUtil, terminal.timeUtil) && Objects.equals(idGenerator, terminal.idGenerator) && Objects.equals(billGenerationSystem, terminal.billGenerationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeUtil, idGenerator, billGenerationSystem);
    }
}
