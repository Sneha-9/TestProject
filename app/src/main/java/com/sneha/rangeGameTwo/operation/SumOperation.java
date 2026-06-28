package com.sneha.rangeGameTwo.operation;

import java.util.List;

public class SumOperation implements Operation {


    @Override
    public int operate(List<Integer> points) {

            int resultSum = 0;
            for (int point : points) {
                resultSum = resultSum + point;
            }
            return resultSum;

    }
}
