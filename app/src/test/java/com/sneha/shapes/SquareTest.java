package com.sneha.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void validSquareLength(){
        assertEquals(4, new Square(2).area());
    }

    @Test
    void throwsExcpetionWhenNegativeSquareLength(){
        Assertions.assertThrows(IllegalArgumentException.class,() ->new Square(-1).area());
    }

    @Test
    void throwsExceptionWhenInvalidSquareLength(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Square(100000).area());
    }

    @Test
    void throwExceptionWhenLengthIsZero(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Square(0).area());
    }

}