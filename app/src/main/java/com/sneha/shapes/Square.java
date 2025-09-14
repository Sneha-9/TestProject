package com.sneha.shapes;

public class Square implements Shape {
    private final float length;

    Square(float length) throws IllegalArgumentException { //This will be illegal argument exception
        if (length > 10000 || length <= 0) { //Can extract this logic to common class
            throw new IllegalArgumentException("Length entered for a square is not valid");

        }
        this.length = length;
    }

    @Override
    public float area() {
        return length * length;
    }
}
