package com.sneha.parkingLot;

import java.util.Objects;

public class Bill {

    private final String id;
    private final float amount;
    private final String vehicleNumber;
    private final String ticketId;
    private final long duration;
    private boolean paid = false;

    Bill(IdGenerator idGenerator, float amount, String vehicleNumber, String ticketId, long duration) throws IllegalArgumentException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be less than or equal to zero for vehicle parking");
        }
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new IllegalArgumentException("Vehicle Number cannot be empty or null");
        }
        if (ticketId == null || ticketId.isEmpty()) {
            throw new IllegalArgumentException("TicketId cannot be empty or null");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration cannot be less than or equal to zero");
        }

        //Validation for others are missing

        this.id = idGenerator.generate();
        this.amount = amount;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
        this.duration = duration;
    }

    void markAsPaid() {
        this.paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", paid=" + paid +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Float.compare(amount, bill.amount) == 0 && paid == bill.paid && duration == bill.duration && Objects.equals(id, bill.id) && Objects.equals(vehicleNumber, bill.vehicleNumber) && Objects.equals(ticketId, bill.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, vehicleNumber, ticketId, paid, duration);
    }
}
