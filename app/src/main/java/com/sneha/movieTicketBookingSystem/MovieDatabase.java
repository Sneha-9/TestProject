package com.sneha.movieTicketBookingSystem;

import java.util.List;

public class MovieDatabase {
    private List<Movie> movies;
    MovieDatabase(List<Movie> movies){
        this.movies = movies;
    }

    List<Movie> getMovies(){

        return movies;
    }

}
