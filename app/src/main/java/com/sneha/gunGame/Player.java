package com.sneha.gunGame;

import com.sneha.gunGame.gun.Gun;
import com.sneha.gunGame.shape.Shape;


public class Player {

    private int id;
    private int point;
    private final Gun gun;

    Player(int id, Gun gun) {
        this.id = id;
        this.gun = gun;
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPoint() {
        this.point = this.point + 1;
    }

    public int getId() {
        return id;
    }

    Shape shoot() {
        Shape shape = gun.fire();
        return shape;
    }

    Gun getGun() {
        return gun;
    }
}
