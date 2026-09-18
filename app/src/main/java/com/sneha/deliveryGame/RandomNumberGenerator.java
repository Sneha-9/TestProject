package com.sneha.deliveryGame;

import java.util.Random;

public class RandomNumberGenerator {

    int generate(int bound){
        int end = bound -1;
        Random r = new Random();

        int value = r.nextInt(end - 0 + 1) + 0;
        return value;
    }
}
