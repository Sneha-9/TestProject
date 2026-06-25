package com.sneha.rangeGame;

import java.util.HashMap;

import java.util.Map;

public interface RoundWinnerRule {
    Player getRoundWinner(int finalPoint);
}


interface Rule {
    boolean isWinner(int finalPoint);
}

class FourPlayerRule implements RoundWinnerRule {

    Map<Player, Rule> playerRuleMap = new HashMap<>();

    FourPlayerRule(Player one, Player two, Player three, Player four) {
        playerRuleMap.put(one, finalPoint -> finalPoint >= 1 && finalPoint <= 10);
        playerRuleMap.put(two, finalPoint -> finalPoint >= 10 && finalPoint <= 20);
        playerRuleMap.put(three, finalPoint -> finalPoint <= -1 && finalPoint >= -10);
        playerRuleMap.put(four, finalPoint -> finalPoint <= -10 && finalPoint >= -20);
    }

    @Override
    public Player getRoundWinner(int finalPoint) {
        var it = playerRuleMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Player, Rule> entry = it.next();
            if (entry.getValue().isWinner(finalPoint)) {
                return entry.getKey();
            }
        }

        return null;
    }
}

class OddEvenRoundRule implements RoundWinnerRule {

    Map<Player, Rule> playerRuleMap = new HashMap<>();

    OddEvenRoundRule(Player one, Player two) {
        playerRuleMap.put(one, finalPoint -> finalPoint % 2 == 0);
        playerRuleMap.put(two, finalPoint -> finalPoint % 2 != 0);
    }

    @Override
    public Player getRoundWinner(int finalPoint) {
        var it = playerRuleMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Player, Rule> entry = it.next();
            if (entry.getValue().isWinner(finalPoint)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
