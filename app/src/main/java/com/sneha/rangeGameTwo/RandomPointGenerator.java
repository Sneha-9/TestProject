package com.sneha.rangeGameTwo;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor

public class RandomPointGenerator implements PointGenerator {
    private PointRange pointRange;


    @Override
    public int generate() {
        Random r = new Random();

        int value = r.nextInt(pointRange.getEnd() - pointRange.getStart() + 1) + pointRange.getStart();
        return value;
    }
}
