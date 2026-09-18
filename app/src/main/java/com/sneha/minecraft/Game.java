package com.sneha.minecraft;




import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class Game {
    private Matrix matrix;
    private RuleExecutorEngine ruleExecutor;
    private AdjacentExposureEngine adjacentExposureEngine;
    private  WinnerValidator winnerValidator;

    void start(){
        Scanner sc = new Scanner(System.in);
        while(true){

            System.out.println("Enter X");
            int x = sc.nextInt();
            System.out.println("Enter Y");
            int y = sc.nextInt();

            Coordinate coordinate = new Coordinate(x, y);

            if(ruleExecutor.execute(matrix,coordinate)){
                System.out.println("BOMB Coordinate");
                break;
            }
            else{
                adjacentExposureEngine.expose(matrix,coordinate);
                if(winnerValidator.validate(matrix)){
                    display(matrix);
                    System.out.println("Winner");
                    break;
                }
                display(matrix);
            }
        }

    }

    private void display(Matrix matrix){
        Cell[][] board = matrix.getBoard();
        for(int i=0;i< matrix.getRow();i++){
            for(int j =0;j< matrix.getColumn();j++){
                if(board[i][j] == Cell.NON_BOMB) {
                    System.out.print(board[i][j] + " ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

    }
}
