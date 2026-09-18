package com.sneha.minecraft;

public class BombRule implements Rule{

    @Override
    public boolean isBomb(Matrix matrix , Coordinate coordinate) {
        return matrix.getCell(coordinate) == Cell.BOMB;
    }
}
