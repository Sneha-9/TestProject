package com.sneha.vendingMachine;

public class Amount {
    private float value;
    Amount(float value){
        if(value <= 0){
            throw  new IllegalArgumentException("Value cannot be negative or zero");
        }
        this.value= value;
    }

}
