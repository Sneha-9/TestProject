package com.sneha.movieTicketBookingSystem;

public class Seat {
    private String id;
    Seat(Idgenerator idgenerator){
        this.id =idgenerator.generate();
    }
}
