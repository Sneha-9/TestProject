package com.sneha.rideHailing;

public class TripDetails {
    private final String id;

    TripDetails(IdGenerator idGenerator) {
        this.id = idGenerator.generate();
    }

    public String getId() {
        return id;
    }
}
