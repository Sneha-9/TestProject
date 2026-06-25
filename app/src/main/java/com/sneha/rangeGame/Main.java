package com.sneha.rangeGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter start of the range");
        int rangeStart = myObj.nextInt();
        System.out.println("Enter end of the range");
        int rangeEnd = myObj.nextInt();
        System.out.println("Enter point divider");
        int value = myObj.nextInt();
        System.out.println("Enter the winning score");
        int winningScore = myObj.nextInt();
        System.out.println("Enter the operator ");
        char operatorValue = myObj.next().charAt(0);
        Operator operator = new Operator(operatorValue);
        Operation operation = new Operation();
        PointsComputationEngine pointsComputationEngine = new PointsComputationEngine(operation);
        Point point = new Point(value);
        PointRange pointRange = new PointRange(rangeStart, rangeEnd);
        PointGenerator pointGenerator = new RandomPointGenerator(pointRange);

        Game game = new Game(pointsComputationEngine, point, pointGenerator, operator);
        game.start(winningScore);
    }
}
