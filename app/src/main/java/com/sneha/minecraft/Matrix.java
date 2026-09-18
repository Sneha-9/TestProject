package com.sneha.minecraft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Matrix {
    private int row;
    private int column;
    Cell board[][] ;

    Matrix(int row, int column, List<Coordinate> coordinates){
        this.row = row;
        this.column= column;
        board = new Cell[row][column];
        for(Coordinate coordinate: coordinates){
            board[coordinate.getX()][coordinate.getY()] = Cell.BOMB;
        }
    }

    Cell getCell(Coordinate coordinate){
        return  board[coordinate.getX()][coordinate.getY()];
    }

    void updateCell(Coordinate coordinate){
        board[coordinate.getX()][coordinate.getX()] = Cell.NON_BOMB;
    }

    Cell[][] getBoard(){
        return board;
    }




}
