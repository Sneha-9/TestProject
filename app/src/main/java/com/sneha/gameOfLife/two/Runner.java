package com.sneha.gameOfLife.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);
        markCellAsLive(
                matrix,
                Arrays.asList(
                        new Coordinate(0, 2),
                        new Coordinate(1,1), new Coordinate(1, 2),
                        new Coordinate(2,0), new Coordinate(2, 1), new Coordinate(2, 2)
                )
        );

        List<Rule> rules = Arrays.asList(new AliveCellRule(), new DeadCellRule());

        Game game = new Game(matrix, rules);

        Matrix result = game.play();

        System.out.println(matrix);
        System.out.println(result);
    }

    private static void markCellAsLive(Matrix matrix, List<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates) {
            matrix.updateCellState(coordinate, State.ALIVE);
        }
    }

}
