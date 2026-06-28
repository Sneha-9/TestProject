package com.sneha.rangeGameTwo.roundRule;

import com.sneha.rangeGameTwo.Player;
import com.sneha.rangeGameTwo.rule.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NPlayerRuleRoundWinnerComputer implements RoundWinnerComputer{

    Map<Player, Rule> playerRule = new HashMap<>();

    public NPlayerRuleRoundWinnerComputer() {

    }

    public void addEntry(Player player, Rule rule) {
        playerRule.put(player, rule);
    }

    @Override
    public Player getRoundWinner(int roundPoint) {
        var iterator = playerRule.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Player, Rule> entry = iterator.next();

            if (entry.getValue().isWinner(roundPoint)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
