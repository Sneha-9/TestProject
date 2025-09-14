package com.sneha.rideHailing;

import java.util.UUID;

public class IdGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }

}
