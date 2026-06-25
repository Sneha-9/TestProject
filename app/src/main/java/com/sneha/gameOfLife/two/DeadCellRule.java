package com.sneha.gameOfLife.two;

import java.util.List;

public class DeadCellRule implements Rule{
    @Override
    public List<Coordinate> getAdjacencyList() {
        return Util.getAdjacentCoordinates();
    }

    @Override
    public State execute(Cell cell, List<Cell> adjacentCells) {
        if (cell.getState() == State.ALIVE) {
            return cell.getState();
        }

        int totalAdjacentAliveCells = 0;

        for (Cell adjacentCell : adjacentCells) {
            if (adjacentCell.getState() == State.ALIVE) {
                totalAdjacentAliveCells += 1;
            }
        }

        if (totalAdjacentAliveCells == 3) {
            return State.ALIVE;
        }

        return State.DEAD;
    }
}
