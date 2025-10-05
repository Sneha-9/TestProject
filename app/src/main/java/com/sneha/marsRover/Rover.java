package com.sneha.marsRover;

public class Rover {
    private Coordinate coordinates;
    private Direction direction;

    Rover(Coordinate coordinates, Direction direction){
        this.coordinates =coordinates;
        this.direction = direction;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    void moveCoordinate(){
        if(direction.getPoint().equals("N")){
          //  System.out.println(direction.getPoint());
            coordinates.incrementY();
        }
        else if(direction.getPoint().equals("S")){
            coordinates.decrementY();
        }
        else if(direction.getPoint().equals("E")){
            coordinates.incrementX();
        }
        else{
            coordinates.decrementX();
        }
    }

    void moveNorth(char movement){

        if(movement== 'L'){
           direction.northAnticlockwise();
       }
       else{
           direction.northClockwise();
       }
    }

    void moveSouth(char movement){
        if(movement== 'L'){
            direction.southAnticlockwise();
        }
        else{
            direction.southClockwise();
        }

    }

    void moveEast(char movement){
        if(movement== 'L'){
            direction.eastAnticlockwise();
        }
        else{
            direction.eastClockwise();
        }
    }

    void moveWest(char movement){
        if(movement== 'L'){
            direction.westAnticlockwise();
        }
        else{
            direction.westClockwise();
        }
    }
}
