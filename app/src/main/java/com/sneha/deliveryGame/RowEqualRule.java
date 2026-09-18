package com.sneha.deliveryGame;

public class RowEqualRule implements Rule{
    @Override
    public boolean areEqual(Coordinate winningCoordinate, Coordinate userCoordinate) {
        return (winningCoordinate.getX() == userCoordinate.getX());
    }
}
