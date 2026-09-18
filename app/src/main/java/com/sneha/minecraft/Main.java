package com.sneha.minecraft;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Coordinate bomb1 = new Coordinate(0,2);
        Coordinate bomb2 = new Coordinate(0,3);
        Coordinate bomb3 = new Coordinate(1,2);
        Coordinate bomb4 = new Coordinate(2,1);
        Coordinate bomb5 = new Coordinate(1,0);
        Coordinate bomb6 = new Coordinate(2,2);
        Coordinate bomb7 = new Coordinate(3,1);

        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(bomb1);
        coordinates.add(bomb2);
        coordinates.add(bomb3);
        coordinates.add(bomb4);
        coordinates.add(bomb5);
        coordinates.add(bomb6);
        coordinates.add(bomb7);
        Matrix matrix = new Matrix(4,4,coordinates);

        Rule rule = new BombRule();
        List<Rule> rules = new ArrayList<>();
        rules.add(rule);
        RuleExecutorEngine ruleExecutorEngine = new RuleExecutorEngine(rules);
        AdjacentExposureEngine adjacentExposureEngine = new AdjacentExposureEngine();
        WinnerValidator winnerValidator = new WinnerValidator();
        Game game = new Game(matrix,ruleExecutorEngine,adjacentExposureEngine,winnerValidator);

        game.start();
    }
}
