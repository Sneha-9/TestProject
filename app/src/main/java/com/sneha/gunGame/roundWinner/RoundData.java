package com.sneha.gunGame.roundWinner;

import com.sneha.gunGame.Player;
import com.sneha.gunGame.shape.Shape;

import java.util.HashMap;
import java.util.Map;

public class RoundData {
    Map<Player, Shape> roundData = new HashMap<>();

    public void update(Player player, Shape shape) {
        roundData.put(player, shape);
    }

    public Map<Player, Shape> getRoundData() {
        return roundData;
    }
}
