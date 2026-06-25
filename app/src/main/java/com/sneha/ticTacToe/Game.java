package com.sneha.ticTacToe;

import kotlin.text.CharCategory;

import java.util.Scanner;

public class Game {
    private Board board;

    Game(Board board){
        this.board = board;
    }

    void start(){
        Scanner myObj = new Scanner(System.in);
        Character ch= Character.X;
        while(true){
            System.out.println("Enter row: ");
            int row = myObj.nextInt();
            System.out.println("Enter column: ");
            int column = myObj.nextInt();

            board.assignSymbol(row, column, ch);
            if(board.winOrNot()){
                System.out.println("Winner is "+ ch);
                board.display();
                break;
            }
            else if(board.fullOrNot() ){
                System.out.println("Board is full, no one won");
                board.display();
                break;
            }

            if(ch == Character.X){
                ch = Character.O;
            }
            else{
                ch = Character.X;
            }

           board.display();
        }
    }
}
