package com.sneha.rangeGame;

public class Game {
    private PointsComputationEngine pointsComputationEngine;
    private Point point;
    private PointGenerator pointGenerator;
    private Operator operator;

    Game(PointsComputationEngine pointsComputationEngine, Point point, PointGenerator pointGenerator, Operator operator) {
        this.point = point;
        this.pointsComputationEngine = pointsComputationEngine;
        this.pointGenerator = pointGenerator;
        this.operator = operator;
    }

    void start(int winningScore) {
        Player p1 = new Player();
        Player p2 = new Player();

        int dividerValue = point.getValue();
        while (true) {
            //randomPoint is not the correct name
            //int aPoint = pointGenerator.generate();
            //int bPoint = ...
            //Player roundWinner = findRoundWinner(aPoint, bPoint);
            //if (hasAWon) ... else ...
            //

            int totalPoint = roundSum();

            pointsComputationEngine.updatePoint(p1, p2, dividerValue, totalPoint, operator.getValue());

            System.out.println("Player " + p1.getId() + " current point " + p1.getPoint());
            System.out.println("Player " + p2.getId() + " current point " + p2.getPoint());

            Player winner = pointsComputationEngine.hasWonOrNot(winningScore, p1, p2);

            if (winner != null) {
                System.out.println("Winner is Player " + winner.getId());
                break;
            }
        }
    }

    private int roundSum() {
        int p1Point = pointGenerator.generate();
        int p2Point = pointGenerator.generate();
        System.out.println("point generated for p1 : " + p1Point);
        System.out.println("point generated for p2 : " + p2Point);

        int totalPoint = p1Point + p2Point;
        return totalPoint;
    }
}
