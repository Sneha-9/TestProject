package com.sneha.marsRover;

public class Controller {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5,5);
        Coordinate coordinate = new Coordinate(3,3);
        Direction direction = new Direction("E");
        String commands = "MMRMMRMRRM";
        Rover rover = new Rover(coordinate,direction);

        System.out.println("initial position : " + rover.getDirection().getPoint() + " "+ rover.getCoordinates().getXCoordinate()+ " "+ rover.getCoordinates().getYCoordinate());

        for(int i = 0;i<commands.length();i++){
          char ch= commands.charAt(i);
          if(ch == 'M'){
              rover.move();
       }
          else {
           rover.rotate(ch);
          }
        }
        System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getXCoordinate() + " "+ rover.getCoordinates().getYCoordinate());
    }

}
