package com.sneha.gunGame.rule;

import com.sneha.gunGame.shape.Shape;

import java.util.List;

public interface Rule {

    Shape isWinner(List<Shape> shapes);
}
