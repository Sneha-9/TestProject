package com.sneha.marsRover;

public class Direction {
    private String point;

    Direction(String point){
        this.point = point;
    }

    void northAnticlockwise(){
        this.point  = "W";
    }

    void northClockwise(){
        this.point  = "E";
    }

    void eastAnticlockwise(){
        this.point  = "N";
    }

    void eastClockwise(){
        this.point  = "S";
    }

    void westAnticlockwise(){
        this.point  = "S";
    }

    void westClockwise(){
        this.point  = "N";
    }

    void southAnticlockwise(){
        this.point  = "E";
    }

    void southClockwise(){
        this.point  = "W";
    }

    public String getPoint() {
        return point;
    }
}
