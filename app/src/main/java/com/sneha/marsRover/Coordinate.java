package com.sneha.marsRover;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    Coordinate(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public  void incrementX(){
        this.xCoordinate = xCoordinate+1;
    }

    public  void decrementX(){
        this.xCoordinate = xCoordinate-1;
    }

    public  void incrementY(){
        this.yCoordinate = yCoordinate+1;
    }

    public  void decrementY(){
        this.yCoordinate = yCoordinate-1;
    }

}
