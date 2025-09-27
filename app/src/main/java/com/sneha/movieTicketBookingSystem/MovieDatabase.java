package com.sneha.movieTicketBookingSystem;

import java.util.List;

public class MovieDatabase {
    private final List<Movie> movies;

    MovieDatabase(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    List<Movie> getMovies() {
        return movies;
    }

}
