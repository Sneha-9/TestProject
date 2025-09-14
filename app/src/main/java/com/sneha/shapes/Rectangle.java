package com.sneha.shapes;

public class Rectangle implements Shape {
    private final float length;
    private final float breadth;

    Rectangle(float length, float breadth) throws IllegalArgumentException {
        if (length > 10000 || length <= 0) {
            throw new IllegalArgumentException("Invalid Length entered for a rectangle");
        }
        if (breadth > 10000 || breadth <= 0) {
            throw new IllegalArgumentException("Invalid Breadth entered for a rectangle");
        }
        this.length = length;
        this.breadth = breadth;

    }


    @Override
    public float area() {
        return length * breadth;
    }
}
