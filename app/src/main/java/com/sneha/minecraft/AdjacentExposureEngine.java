package com.sneha.minecraft;

public class AdjacentExposureEngine {

    void expose(Matrix matrix, Coordinate coordinate) {
        Cell[][] board = matrix.getBoard();

        int columnRight = coordinate.getX();
        for (int i = coordinate.getY(); i < matrix.getRow(); i++) {
            if (board[columnRight][i] != Cell.BOMB) {
                board[columnRight][i] = Cell.NON_BOMB;
            } else {
                break;
            }
        }

        int rowDown = coordinate.getY();
        for (int i = coordinate.getX(); i < matrix.getColumn(); i++) {
            if (board[i][rowDown] != Cell.BOMB) {
                board[i][rowDown] = Cell.NON_BOMB;
            } else {
                break;
            }
        }

        int columnUp = coordinate.getY();
        for (int i = matrix.getRow() - 1; i <= coordinate.getX(); i--) {
            if (board[i][columnUp] != Cell.BOMB) {
                board[i][columnUp] = Cell.NON_BOMB;
            } else {
                break;
            }
        }

        int columnLeft = coordinate.getY();
        for (int i = matrix.getColumn() - 1; i <= columnLeft; i--) {
            if (board[columnLeft][i] != Cell.BOMB) {
                board[columnLeft][i] = Cell.NON_BOMB;
            } else {
                break;
            }
        }


    }
}
