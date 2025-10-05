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
          //  System.out.println(ch);
          if(ch == 'M'){
              rover.moveCoordinate();
             // System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getYCoordinate() + " "+ rover.getCoordinates().getXCoordinate());

          }
          else {
             // System.out.println( rover.getDirection().getPoint());
              if(rover.getDirection().getPoint().equals("N")){
                  rover.moveNorth(ch);
                 // System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getYCoordinate() + " "+ rover.getCoordinates().getXCoordinate());
              }
              else if(rover.getDirection().getPoint().equals("S")){
                  rover.moveSouth(ch);
                 // System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getYCoordinate() + " "+ rover.getCoordinates().getXCoordinate());

              }
              else if(rover.getDirection().getPoint().equals("E")){
                  rover.moveEast(ch);
                 // System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getYCoordinate() + " "+ rover.getCoordinates().getXCoordinate());
              }
              else if(rover.getDirection().getPoint().equals("W")){
                  rover.moveWest(ch);
                 // System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getYCoordinate() + " "+ rover.getCoordinates().getXCoordinate());
              }
          }

        }

        System.out.println(rover.getDirection().getPoint()+ " "+ rover.getCoordinates().getXCoordinate() + " "+ rover.getCoordinates().getYCoordinate());
    }

}
