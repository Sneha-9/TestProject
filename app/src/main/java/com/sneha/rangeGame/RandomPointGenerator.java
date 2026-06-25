package com.sneha.rangeGame;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator{
    private PointRange pointRange;

    RandomPointGenerator(PointRange pointRange){
        this.pointRange = pointRange;
    }
    @Override
    public int generate() {
        Random r = new Random();

        int value = r.nextInt(pointRange.getEnd() - pointRange.getStart() + 1) + pointRange.getStart();
        return value;
    }
}
