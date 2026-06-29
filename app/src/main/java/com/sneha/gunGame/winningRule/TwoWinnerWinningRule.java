package com.sneha.gunGame.winningRule;

import com.sneha.gunGame.Player;

import java.util.List;

//This should have been a interface
public class TwoWinnerWinningRule implements WinningRule {

    public Player getWinner(List<Player> players) {
        Player one = players.get(0);
        Player two = players.get(1);

        if (one.getPoint() > two.getPoint()) {
            return one;
        } else if (one.getPoint() < two.getPoint()) {
            return two;
        }
        return null;
    }
}
