package com.sneha.movieTicketBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    private final String id;
    private final String currentMovieId;
    private final List<Seat> seats;

    Hall(Idgenerator idgenerator, List<Seat> seats, String currentMovieId) {
        this.id = idgenerator.generate();
        this.seats = seats;
        this.currentMovieId = currentMovieId;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> result = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                result.add(seat);
            }
        }
        return result;
    }

    public String getCurrentMovieId() {
        return currentMovieId;
    }

}
