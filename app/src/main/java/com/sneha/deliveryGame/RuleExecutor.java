package com.sneha.deliveryGame;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RuleExecutor {

    List<Rule> rules;

    ExecutionResult execute(Coordinate winningCoordinate, Coordinate userCoordinate){
        boolean allEqualRuleResult = rules.get(0).areEqual(winningCoordinate,userCoordinate);
        if(allEqualRuleResult){
            return ExecutionResult.WON;
        }

        boolean rowEqualRuleResult = rules.get(1).areEqual(winningCoordinate,userCoordinate);
        if(rowEqualRuleResult){
            return ExecutionResult.ROWMATCH;
        }

        boolean columnEqualRuleResult = rules.get(2).areEqual(winningCoordinate,userCoordinate);
        if(columnEqualRuleResult){
            return ExecutionResult.COLUMNMATCH;
        }

        return ExecutionResult.NONE;

    }
}
