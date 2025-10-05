package com.sneha.marsRover;

public class Plateau {
    private int XCoordinate;
    private int YCoordinate;

    Plateau(int XCoordinate, int YCoordinate){
        this.XCoordinate = XCoordinate;
        this.YCoordinate=YCoordinate;
    }

    boolean validateCoordinate(Coordinate coordinate){
        if(coordinate.getXCoordinate() > XCoordinate || coordinate.getYCoordinate() > YCoordinate){
            return false;
        }

        return true;
    }
}
