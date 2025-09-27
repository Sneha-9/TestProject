package com.sneha.movieTicketBookingSystem;

public class Seat {
    private final String id;
    private boolean isAvailable;

    Seat(Idgenerator idgenerator) {
        this.id = idgenerator.generate();
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void updateAvailability() {
        this.isAvailable = false;
    }
}
