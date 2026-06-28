package com.sneha.rangeGameTwo.roundRule;

import com.sneha.rangeGameTwo.Player;
import com.sneha.rangeGameTwo.rule.EvenRule;
import com.sneha.rangeGameTwo.rule.OddRule;
import com.sneha.rangeGameTwo.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class OddEvenRoundWinnerComputer implements RoundWinnerComputer {
    Map<Player, Rule> oddEvenRule = new HashMap<>();

    public OddEvenRoundWinnerComputer(Player one, Player two) {
        oddEvenRule.put(one, new EvenRule());
        oddEvenRule.put(two, new OddRule());
    }

    @Override
    public Player getRoundWinner(int roundPoint) {
        var iterator = oddEvenRule.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Player, Rule> entry = iterator.next();
            if (entry.getValue().isWinner(roundPoint)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
