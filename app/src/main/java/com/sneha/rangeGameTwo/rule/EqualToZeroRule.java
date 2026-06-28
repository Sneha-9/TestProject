package com.sneha.rangeGameTwo.rule;

public class EqualToZeroRule implements Rule{

    @Override
    public boolean isWinner(int roundPoint) {
        return roundPoint == 0;
    }
}
