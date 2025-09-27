package com.sneha.movieTicketBookingSystem;

public class TicketGenerationSystem {
    private Idgenerator idgenerator;
    private Movie movie;


    Ticket generateTicket(){
        return new Ticket(idgenerator,0,movie.toString());
    }
}
