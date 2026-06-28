package com.sneha.rangeGameTwo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointStore {
    private final Map<Player, Integer> pointStore = new HashMap();

    void add(Player player, int randomRoundPoint) {
        pointStore.put(player, randomRoundPoint);
    }

    List<Integer> getPoints() {
        List<Integer> pointsSet = new ArrayList<>();
        for (Player player : pointStore.keySet()) {
            pointsSet.add(pointStore.get(player));
        }
        return pointsSet;
    }

    List<Player> getPlayers() {
        List<Player> playerSet = new ArrayList<>();
        for (Player player : pointStore.keySet()) {
            playerSet.add(player);
        }
        return playerSet;
    }
}
