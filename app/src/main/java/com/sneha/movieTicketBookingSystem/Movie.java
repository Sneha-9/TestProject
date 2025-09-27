package com.sneha.movieTicketBookingSystem;

public class Movie {
    private final String id;
    private final String name;
    private final long startTime;
    private final long duration;

    Movie(Idgenerator idgenerator, String name, long startTime, long duration) {
        this.duration = duration;
        this.name = name;
        this.id = idgenerator.generate();
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

}
