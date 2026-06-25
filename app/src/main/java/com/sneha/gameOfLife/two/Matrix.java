package com.sneha.gameOfLife.two;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Matrix implements Iterator<Coordinate> {

    private int row;
    private int col;

    private int currI = 0;
    private int currJ = 0;

    private Cell[][] board;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;

        board = new Cell[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = new Cell(State.DEAD);
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void updateCellState(Coordinate coordinate, State newState) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (!isValidCoordinate(x, y)) {
            return;
        }

        board[x][y].updateState(newState);
    }

    public Cell getValueAtCoordinate(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (!isValidCoordinate(x, y)) {
            return null;
        }

        return this.board[x][y];
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    @Override
    public boolean hasNext() {
        return currI < row;
    }

    @Override
    public Coordinate next() {
        Coordinate currCoordinate = new Coordinate(currI, currJ);

        if (currJ < col) {
            currJ += 1;
        }

        if (currJ == col) {
            currI += 1;
            currJ = 0;
        }

        return currCoordinate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                builder.append(this.board[i][j]);
                builder.append(" ");
            }

            builder.append("\n");
        }

        return builder.toString();
    }
}
