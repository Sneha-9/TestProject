package com.sneha.rangeGameTwo.rule;

public class GreaterThanZeroRule implements Rule {


    @Override
    public boolean isWinner(int roundPoint) {
        return roundPoint > 0;

    }
}
