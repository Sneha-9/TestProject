package com.sneha.deliveryGame;

public class InputValidator {

    boolean validateBound(int input, int bound){
        if(input< bound)
            return true;
        else
            return false;
    }
}
