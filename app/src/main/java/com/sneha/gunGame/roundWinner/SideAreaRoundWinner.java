package com.sneha.gunGame.roundWinner;

import com.sneha.gunGame.Player;
import com.sneha.gunGame.rule.AreaRule;
import com.sneha.gunGame.rule.Rule;
import com.sneha.gunGame.rule.SideRule;
import com.sneha.gunGame.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SideAreaRoundWinner implements RoundWinner {
    List<Rule> ruleList = new ArrayList<>();

    public SideAreaRoundWinner() {
        ruleList.add(new SideRule());
        ruleList.add(new AreaRule());
    }

    @Override
    public Player getRoundWinner(RoundData roundData) {

        List<Shape> shapes = new ArrayList<>();
        var iterator = roundData.getRoundData().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Player, Shape> entry = iterator.next();
            shapes.add(entry.getValue());
        }

        Rule sideRule = ruleList.get(0);
        Shape sideShapeWinner = sideRule.isWinner(shapes);

        if (sideShapeWinner == null) {
            Rule areaRule = ruleList.get(1);
            Shape areaShapeWinner = areaRule.isWinner(shapes);
            if (areaShapeWinner == null) {
                return null;
            } else {
                return getAreaWinnerPlayer(roundData, areaShapeWinner);
            }

        } else {
            return getSideWinnerPlayer(roundData, sideShapeWinner);
        }

    }

    private Player getAreaWinnerPlayer(RoundData roundData, Shape areaWinnerShape) {
        var iterator = roundData.getRoundData().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Player, Shape> entry = iterator.next();
            if (entry.getValue().getArea() == areaWinnerShape.getArea()) {
                return entry.getKey();
            }
        }
        return null;
    }

    private Player getSideWinnerPlayer(RoundData roundData, Shape sideWinnerShape) {
        var iterator = roundData.getRoundData().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Player, Shape> entry = iterator.next();
            if (entry.getValue().getSide() == sideWinnerShape.getSide()) {
                return entry.getKey();
            }
        }
        return null;
    }
}
