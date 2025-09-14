package com.sneha.rideHailing;

public class Cab {
    private final String type;
    private final String number;
    private float baseFare;

    Cab(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}
