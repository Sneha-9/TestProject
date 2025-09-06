package com.sneha.parkingLot;

public class BillGenerationSystem {
    //private Ticket ticket;
//    private final long endTime = System.currentTimeMillis();

    private TimeUtil timeUtil;
    private IdGenerator idGenerator;
    private String regex ="^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
    public BillGenerationSystem(IdGenerator idGenerator, TimeUtil timeUtil)throws IllegalArgumentException {
        if(idGenerator == null ){
            throw  new IllegalArgumentException("Id cannot be null");
        }
        if(!idGenerator.generate().matches(regex)){
            throw new IllegalArgumentException("Id is not valid");
        }
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
    }


    Bill generateBill(Ticket ticket)throws IllegalArgumentException {
        long duration = timeUtil.getCurrentTime() - ticket.getStartTime();
        float amount = duration * 10;

        Bill bill = new Bill(idGenerator, amount, ticket.getVehicleNumber(), ticket.getTicketId(), duration);

        return bill;
    }

}
