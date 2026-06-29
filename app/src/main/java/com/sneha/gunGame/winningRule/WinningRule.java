package com.sneha.gunGame.winningRule;

import com.sneha.gunGame.Player;

import java.util.List;

public interface WinningRule {
    Player getWinner(List<Player> players);
}
