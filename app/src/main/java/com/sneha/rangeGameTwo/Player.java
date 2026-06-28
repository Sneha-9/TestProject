package com.sneha.rangeGameTwo;

import lombok.Getter;

@Getter

public class Player {
    private int points;

    Player() {
        this.points = 0;
    }

    public void incrementPoint() {
        this.points = points + 1;
    }


}
