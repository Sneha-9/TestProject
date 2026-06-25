package com.sneha.ticTacToe;

public class TicTacToe {

    public static void main(String args[]){
        Board board = new Board(3,3);
        Game game = new Game(board);

        game.start();
    }
}
