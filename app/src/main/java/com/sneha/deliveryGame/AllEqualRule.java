package com.sneha.deliveryGame;

public class AllEqualRule implements Rule{

    @Override
    public boolean areEqual(Coordinate winningCoordinate, Coordinate userCoordinate) {
        return (winningCoordinate.getX() == userCoordinate.getX()) && (winningCoordinate.getY() == userCoordinate.getY());
    }
}
