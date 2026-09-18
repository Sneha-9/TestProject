package com.sneha.deliveryGame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AllEqualRule allEqualRule = new AllEqualRule();
        ColumnEqualRule columnEqualRule = new ColumnEqualRule();
        RowEqualRule rowEqualRule = new RowEqualRule();

        List<Rule> rulesList = new ArrayList<>();

        rulesList.add(allEqualRule);
        rulesList.add(rowEqualRule);
        rulesList.add(columnEqualRule);

        RuleExecutor ruleExecutor = new RuleExecutor(rulesList);

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        InputValidator inputValidator = new InputValidator();

        Game game = new Game(randomNumberGenerator,inputValidator, ruleExecutor);

        game.start(3);
    }


}
