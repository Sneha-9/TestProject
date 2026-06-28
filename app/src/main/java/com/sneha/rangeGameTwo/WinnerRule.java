package com.sneha.rangeGameTwo;

import java.util.List;

public class WinnerRule {

    Player getGameWinner(Player player, int winningPoint) {

            if (player.getPoints() == winningPoint) {
                return player;
            }

        return null;
    }

}
