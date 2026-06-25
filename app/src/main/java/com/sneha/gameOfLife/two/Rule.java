package com.sneha.gameOfLife.two;

import java.util.List;

public interface Rule {

    List<Coordinate> getAdjacencyList();

    State execute(Cell cell, List<Cell> adjacentCells);

}
