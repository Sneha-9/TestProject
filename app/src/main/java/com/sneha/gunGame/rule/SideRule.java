package com.sneha.gunGame.rule;

import com.sneha.gunGame.shape.Shape;

import java.util.List;

public class SideRule implements Rule {

    @Override
    public Shape isWinner(List<Shape> shapes) {

        Shape playerOne = shapes.get(0);
        Shape playerTwo = shapes.get(1);

        if (playerOne.getSide() > playerTwo.getSide()) {
            return playerOne;
        } else if (playerOne.getSide() < playerTwo.getSide()) {
            return playerTwo;
        } else return null;
    }
}
