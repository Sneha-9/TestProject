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

    void move(){
        if(direction.getPoint().equals("N")){
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

    void rotate(char movement){

        if(movement== 'L'){
           direction.rotateLeft();
       }
       else{
           direction.rotateRight();
       }
    }

}
