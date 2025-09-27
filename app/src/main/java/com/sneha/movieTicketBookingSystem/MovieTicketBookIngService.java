package com.sneha.movieTicketBookingSystem;

import java.util.List;

public class MovieTicketBookIngService {
    private MovieDatabase movieDatabase;
    private HallDatabase hallDatabase;
    private Idgenerator idgenerator;
    private TicketGenerationSystem ticketGenerationSystem;

    List<Movie> getAvailableMovies() {
        return movieDatabase.getMovies();
    }

    List<Seat> getAvailableSeat(String movieId) {
        Hall hall = hallDatabase.getHall(movieId);
        List<Seat> availableSeats = hall.getAvailableSeats();
        return availableSeats;
    }

    Ticket bookSeat(Seat seat) {
        seat.updateAvailability();
        return ticketGenerationSystem.generateTicket();
    }
}
