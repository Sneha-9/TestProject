package com.sneha.movieTicketBookingSystem;

public class Ticket {
    private final String id;

    Ticket(Idgenerator idgenerator) {
        this.id = idgenerator.generate();
    }

}
