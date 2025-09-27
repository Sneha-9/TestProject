package com.sneha.movieTicketBookingSystem;

import java.util.UUID;

public class Idgenerator {
    String generate(){
       return UUID.randomUUID().toString();
    }
}
