package com.sneha.marsRover;

public class Plateau {
    private final int XCoordinate;
    private final int YCoordinate;

    Plateau(int XCoordinate, int YCoordinate) {
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
    }

    boolean validateCoordinate(Coordinate coordinate) {
        return coordinate.getXCoordinate() <= XCoordinate && coordinate.getYCoordinate() <= YCoordinate;
    }
}
