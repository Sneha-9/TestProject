package com.sneha.deliveryGame;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Game {

    private RandomNumberGenerator randomNumberGenerator;
    private InputValidator inputValidator;
    private RuleExecutor ruleExecutor;

    void start(int bound) {

        int xCoordinate = randomNumberGenerator.generate(bound);
        int yCoordinate = randomNumberGenerator.generate(bound);

        Coordinate winningCoordinate = new Coordinate(xCoordinate, yCoordinate);

        System.out.println(winningCoordinate.getX() + " " + winningCoordinate.getY());

        List<Integer> blacklistedRows = new ArrayList<>();
        List<Integer> blacklistedColumn = new ArrayList<>();

        while (true) {
            System.out.println("X Coordinate ");
            int userXCoordinate = input(bound);

            System.out.println("Y Cooridnate");
            int userYCoordinate = input(bound);


            Coordinate userCoordinate = new Coordinate(userXCoordinate, userYCoordinate);

            ExecutionResult executionResult = ruleExecutor.execute(winningCoordinate, userCoordinate);

            if (executionResult.equals(ExecutionResult.WON)) {
                System.out.println("Winner");
                break;
            } else if (executionResult.equals(ExecutionResult.ROWMATCH)) {
                System.out.println("Row is Correct " + userCoordinate.getX());
                System.out.println("Blacklisted Row " + blacklistedRows);

                blacklistedColumn.add(userYCoordinate);
                System.out.println("BlackListed Column " + blacklistedColumn);

                System.out.println("Enter Y coordinate again");
                int columnCoordinate = input(bound);
                Coordinate newUserCoordinate = new Coordinate(userXCoordinate, columnCoordinate);

                executionResult = ruleExecutor.execute(winningCoordinate, newUserCoordinate);

                if (executionResult.equals(ExecutionResult.WON)) {
                    System.out.println("Winner");
                } else {
                    System.out.println("Not Winner");
                }
                break;

            } else if (executionResult.equals(ExecutionResult.COLUMNMATCH)) {
                System.out.println("Column is Correct " + userCoordinate.getY());

                blacklistedRows.add(userXCoordinate);
                System.out.println("Blacklisted Row " + blacklistedRows);

                System.out.println("BlackListed Column " + blacklistedColumn);

                System.out.println("Enter Y coordinate again");
                int columnCoordinate = input(bound);
                Coordinate newUserCoordinate = new Coordinate(userXCoordinate, columnCoordinate);

                executionResult = ruleExecutor.execute(winningCoordinate, newUserCoordinate);

                if (executionResult.equals(ExecutionResult.WON)) {
                    System.out.println("Winner");

                } else {
                    System.out.println("Not Winner");

                }
                break;

            } else {
                blacklistedRows.add(userXCoordinate);
                System.out.println("Blacklisted Row " + blacklistedRows);
                blacklistedColumn.add(userYCoordinate);
                System.out.println("BlackListed Column " + blacklistedColumn);
            }


        }
    }

    private int input(int bound) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  coordinate");
        int userCoordinate = sc.nextInt();
        boolean isXValid = inputValidator.validateBound(userCoordinate, bound);
        if (!isXValid) {
            System.out.println("invalid coordinate");
            userCoordinate = -1;
        }
        return userCoordinate;
    }
}
