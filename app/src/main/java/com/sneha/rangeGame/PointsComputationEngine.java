package com.sneha.rangeGame;

public class PointsComputationEngine {
    private Operation operation;
    PointsComputationEngine(Operation operation){
        this.operation = operation;
    }
    Player hasWonOrNot(int winPoint,  Player  p1, Player p2){
      if(p1.getPoint() == winPoint){
          return p1;
      }
       if(p2.getPoint() == winPoint){
          return p2;
      }
      else{
          return null;
      }
    }

    void updatePoint(Player p1, Player p2, int pointDivider, int totalPoint, char operator){
        int result = operation.operate(operator, totalPoint, pointDivider);
        resultValidation(result, p1, p2);
    }

    private void resultValidation(int result, Player p1, Player p2){
        if(result == 0){
            p1.incrementPoint();
        }
        else{
            p2.incrementPoint();
        }
    }

}
