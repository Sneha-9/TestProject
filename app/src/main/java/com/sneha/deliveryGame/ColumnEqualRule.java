package com.sneha.deliveryGame;

public class ColumnEqualRule implements Rule{
    @Override
    public boolean areEqual(Coordinate winningCoordinate, Coordinate userCoordinate) {
        return (winningCoordinate.getY() == userCoordinate.getY());
    }
}
