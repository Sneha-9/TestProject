package com.sneha.movieTicketBookingSystem;

public class TicketGenerationSystem {
    private final Idgenerator idgenerator;

    public TicketGenerationSystem(Idgenerator idgenerator) {
        this.idgenerator = idgenerator;
    }

    Ticket generateTicket() {
        return new Ticket(idgenerator);
    }
}
