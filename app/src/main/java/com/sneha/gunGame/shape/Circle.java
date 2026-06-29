package com.sneha.gunGame.shape;

public class Circle implements Shape {
    private final int side;
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
        this.side = Integer.MAX_VALUE;
    }

    @Override
    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

}
