package com.sneha.gunGame.shape;

public class Rectangle implements Shape {
    private final int length;
    private final int breadth;
    private final int side;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        this.side = 4;
    }

    @Override
    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return 2 * length * breadth;
    }
}
