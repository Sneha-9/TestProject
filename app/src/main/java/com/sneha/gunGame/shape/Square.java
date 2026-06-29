package com.sneha.gunGame.shape;

public class Square implements Shape {
    private final int side;
    private final int length;

    public Square(int length) {
        this.length = length;
        this.side = 4;
    }

    @Override
    public int getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return length * length;
    }
}
