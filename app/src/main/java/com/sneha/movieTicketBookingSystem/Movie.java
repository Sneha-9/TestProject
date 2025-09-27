package com.sneha.movieTicketBookingSystem;

public class Movie {
    private String id;
    private String name;
    private long startTime;
    private long duration;

    Movie(Idgenerator idgenerator, String name, long startTime, long duration){
        this.duration = duration;
        this.name = name;
        this.id = idgenerator.generate();
        this.startTime = startTime;
    }
}
