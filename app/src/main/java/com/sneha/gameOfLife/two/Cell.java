package com.sneha.gameOfLife.two;

public class Cell {
    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void updateState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.getState().toString();
    }
}
