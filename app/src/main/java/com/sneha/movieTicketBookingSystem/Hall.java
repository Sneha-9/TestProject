package com.sneha.movieTicketBookingSystem;

public class Hall {
    private String id;
    Hall(Idgenerator idgenerator){
        this.id = idgenerator.generate();
    }

    public String getId() {
        return id;
    }
}
