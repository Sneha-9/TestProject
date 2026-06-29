package com.sneha.gunGame;

import com.sneha.gunGame.gun.Gun;
import com.sneha.gunGame.gun.ShapeGun;
import com.sneha.gunGame.roundWinner.RoundWinner;
import com.sneha.gunGame.roundWinner.SideAreaRoundWinner;
import com.sneha.gunGame.shape.Circle;
import com.sneha.gunGame.shape.Rectangle;
import com.sneha.gunGame.shape.Square;
import com.sneha.gunGame.winningRule.TwoWinnerWinningRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Player> playerList = new ArrayList<>();

        Gun playerOneGun = new ShapeGun();
        playerOneGun.add(new Square(2));
        playerOneGun.add(new Rectangle(16, 4));
        playerOneGun.add(new Circle(3));

        Gun playerTwoGun = new ShapeGun();
        playerTwoGun.add(new Rectangle(4, 1));
        playerTwoGun.add(new Square(4));
        playerTwoGun.add(new Circle(3));

        playerList.add(new Player(1, playerOneGun));
        playerList.add(new Player(2, playerTwoGun));

        RoundWinner roundWinner = new SideAreaRoundWinner();
        TwoWinnerWinningRule twoWinnerWinningRule = new TwoWinnerWinningRule();

        Game game = new Game(playerList, roundWinner, twoWinnerWinningRule);
        game.start();
    }


}
