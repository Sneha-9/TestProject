package com.sneha.gunGame.gun;

import com.sneha.gunGame.shape.Shape;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ShapeGun implements Gun {
    List<Shape> shapes = new ArrayList<>();

    @Override
    public Shape fire() {
        if (!isEmpty()) {
            Shape shape = shapes.remove(0);
            return shape;
        } else return null; //should throw exception
    }

    @Override
    public boolean isEmpty() {
        return shapes.isEmpty();
    }

    @Override
    public void add(Shape shape) {
        shapes.add(shape);
    }


}
