package com.sneha.minecraft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RuleExecutorEngine {
    private List<Rule> ruleList;

    boolean execute(Matrix matrix, Coordinate coordinate) {
        for (Rule rule : ruleList) {
            return rule.isBomb(matrix, coordinate);
        }

        return false;
    }
}
