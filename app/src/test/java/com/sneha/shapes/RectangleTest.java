package com.sneha.shapes;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    void validRectangleLength() {
        Assertions.assertEquals(4, new Rectangle(2, 2).area());
    }

    @Test
    void throwsExceptionWhenNegativeRectangleLengthAndBreadth() { // Doesnt cover case when either is negative
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, -1).area());
    }

    @Test
    void throwsExceptionWhenInvalidRectangleLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(100000, 2).area());
    }

    @Test
    void throwExceptionWhenLengthIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 8).area());
    }
}
