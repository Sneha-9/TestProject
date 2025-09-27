package com.sneha.movieTicketBookingSystem;

import java.util.List;

public class HallDatabase {
    private final List<Hall> halls;

    HallDatabase(List<Hall> halls) {
        this.halls = halls;
    }

    Hall getHall(String movieId) {
        for (Hall h : halls) {
            if (h.getCurrentMovieId().equals(movieId)) {
                return h;
            }
        }
        return null;
    }


}
