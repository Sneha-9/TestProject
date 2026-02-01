package com.sneha.marsRover;

public class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public void incrementX() {
        this.x = x + 1;
    }

    public void decrementX() {
        this.x = x - 1;
    }

    public void incrementY() {
        this.y = y + 1;
    }

    public void decrementY() {
        this.y = y - 1;
    }

}
