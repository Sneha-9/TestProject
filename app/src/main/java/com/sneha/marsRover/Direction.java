package com.sneha.marsRover;

public class Direction {
    private String point;

    Direction(String point) {
        this.point = point;
    }

    void rotateLeft() {
        if (point.equals("N")) {
            this.point = "W";
        } else if (point.equals("E")) {
            this.point = "N";
        } else if (point.equals("W")) {
            this.point = "S";
        } else {
            this.point = "E";
        }
    }

    void rotateRight() {
        if (point.equals("N")) {
            this.point = "E";
        } else if (point.equals("E")) {
            this.point = "S";
        } else if (point.equals("W")) {
            this.point = "N";
        } else {
            this.point = "W";
        }
    }

    public String getPoint() {
        return point;
    }
}
