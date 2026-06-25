package com.sneha.rangeGame;

public class Player {
    private int point;
    private String id;

    //Is point required
    Player(){
        this.id = new IdGenerator().generate();
        this.point = 0;
    }

    public int getPoint() {
        return point;
    }

    public void incrementPoint(){
        this.point = this.point + 1;
    }

    public String getId() {
        return id;
    }
}
