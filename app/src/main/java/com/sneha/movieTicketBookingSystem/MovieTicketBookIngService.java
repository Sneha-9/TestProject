package com.sneha.movieTicketBookingSystem;

import java.util.List;

public class MovieTicketBookIngService {
    private final MovieDatabase movieDatabase;
    private final HallDatabase hallDatabase;
    private final Idgenerator idgenerator;
    private TicketGenerationSystem ticketGenerationSystem;

    MovieTicketBookIngService(MovieDatabase movieDatabase, Idgenerator idgenerator, HallDatabase hallDatabase) {
        this.movieDatabase = movieDatabase;
        this.hallDatabase = hallDatabase;
        this.idgenerator = idgenerator;
    }

    List<Movie> getAvailableMovies() throws Exception {
        List<Movie> availableMovies = movieDatabase.getMovies();
        if (availableMovies == null) {
            throw new Exception("No movie available at the moment");
        }
        return availableMovies;
    }

    List<Seat> getAvailableSeat(String movieId) throws Exception {
        Hall hall = hallDatabase.getHall(movieId);
        if (hall == null) {
            throw new Exception("Movie Id is invalid");
        }
        List<Seat> availableSeats = hall.getAvailableSeats();
        if (availableSeats == null) {
            throw new Exception("House Full");
        }
        return availableSeats;
    }

    Ticket bookSeat(Seat seat) {
        seat.updateAvailability();

        return ticketGenerationSystem.generateTicket();
    }
}
