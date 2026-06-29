package com.sneha.gunGame.gun;

import com.sneha.gunGame.shape.Shape;

public interface Gun {
    Shape fire();

    boolean isEmpty();

    void add(Shape shape);

}
