package com.sneha.chucksGame;

import java.util.Random;

public class RandomPointGenerator {
    private int endRange  =11;
    private int startRange =0;

    int generate(){
        Random r = new Random();

        int value = r.nextInt(endRange - startRange + 1) + startRange;
        return value;
    }
}
