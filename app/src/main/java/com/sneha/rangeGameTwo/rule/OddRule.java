package com.sneha.rangeGameTwo.rule;

public class OddRule implements Rule {

    @Override
    public boolean isWinner(int roundPoint) {

        return roundPoint % 2 != 0;
    }
}
