package com.sneha.gameOfLife.two;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<Coordinate> getAdjacentCoordinates() {
        return Arrays.asList(
                new Coordinate(-1, -1), new Coordinate(-1, 0), new Coordinate(-1, 1),
                new Coordinate(0, -1), new Coordinate(0, 1),
                new Coordinate(1, -1), new Coordinate(1, 0), new Coordinate(1, 1)
        );
    }

}
