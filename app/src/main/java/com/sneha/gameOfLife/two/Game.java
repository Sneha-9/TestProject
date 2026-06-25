package com.sneha.gameOfLife.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Matrix matrix;
    public List<Rule> rules;

    public Game(Matrix matrix, List<Rule> rules) {
        this.matrix = matrix;
        this.rules = rules;
    }

    public Matrix play() {

        Matrix result = new Matrix(this.matrix.getRow(), this.matrix.getCol());

        while (this.matrix.hasNext()) {
            Coordinate coordinate = this.matrix.next();

            Cell cell = this.matrix.getValueAtCoordinate(coordinate);

            State newState = getNewState(cell, coordinate);

            result.updateCellState(coordinate, newState);
        }

        return result;
    }

    private State getNewState(Cell cell, Coordinate coordinate) {
        for (Rule rule: this.rules) {
            List<Coordinate> adjacentCoordinates = rule.getAdjacencyList();

            List<Cell> adjacentCells = new ArrayList<>();

            for (Coordinate adjacentCoordinate: adjacentCoordinates) {

                Cell adjacentCell = this.matrix.getValueAtCoordinate(
                        new Coordinate(
                                coordinate.getX() + adjacentCoordinate.getX(),
                                coordinate.getY() + adjacentCoordinate.getY()
                        )
                );
                if (adjacentCell == null) {
                    continue;
                }

                adjacentCells.add(adjacentCell);
            }

            State updatedState = rule.execute(cell, adjacentCells);

            if (updatedState != cell.getState()) {
                return updatedState;
            }
        }

        return cell.getState();
    }

}
