package com.sneha.minecraft;

public class WinnerValidator {
    boolean validate(Matrix matrix){
        Cell[][] board = matrix.getBoard();
        for(int i=0;i< matrix.getRow();i++){
            for(int j=0;j< matrix.getColumn();j++){
                if(board[i][j] == null){
                  return false;
                }
            }
        }
        return true;
    }
}
