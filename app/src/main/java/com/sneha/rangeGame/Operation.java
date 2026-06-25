package com.sneha.rangeGame;

public class Operation {

    int operate(char value, int pointOne, int pointTwo){
        if(value == '+'){
            return 0;
        }
        else if(value == '%'){
         return   pointOne % pointTwo;
        }
        else if(value == '-'){
            return  0;
        }
        else{
            return 0;
        }
    }
}
