package com.sneha.gameOfLife.two;

import java.util.List;

public class AliveCellRule implements Rule{

    @Override
    public List<Coordinate> getAdjacencyList() {
        return Util.getAdjacentCoordinates();
    }

    @Override
    public State execute(Cell cell, List<Cell> adjacentCells) {
        if (cell.getState() == State.DEAD) {
            return cell.getState();
        }

        int totalLiveAdjacentCells = 0;

        for (Cell adjacentCell : adjacentCells) {
            if (adjacentCell.getState() == State.ALIVE) {
                totalLiveAdjacentCells += 1;
            }
        }

        if (totalLiveAdjacentCells >= 2 && totalLiveAdjacentCells <= 3) {
            return State.ALIVE;
        }

        return State.DEAD;
    }

}
