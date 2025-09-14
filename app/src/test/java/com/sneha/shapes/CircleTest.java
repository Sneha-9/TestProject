package com.sneha.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @Test
    void validCirleArea() { // The test name is not clear
        assertEquals(28.274333953857422, new Circle(3).area());
    }

    @Test
    void validCircleCircumference() {
        assertEquals(12.566370964050293, new Circle(2).circumference());
    }

    @Test
    void throwsExceptionWhenRadiusIsZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Circle(0).area());
    }

    @Test
    void throwsExceptionWhenInvalidCircleRadius() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Circle(100000).area());
    }

}