package com.sneha.movieTicketBookingSystem;

public class Ticket {
    private String id;
    private float amount;
    private String movieName;

    Ticket(Idgenerator idgenerator, float amount, String movieName){
        this.amount= amount;
        this.movieName = movieName;
        this.id = idgenerator.generate();
    }

}
