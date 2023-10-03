package com.ilestegor.lab2.model;

public class Coordinates {
    private final double x;
    private final double y;
    private final double r;

    public Coordinates(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;

        Coordinates that = (Coordinates) o;

        if (Double.compare(x, that.x) != 0) return false;
        if (Double.compare(y, that.y) != 0) return false;
        return Double.compare(r, that.r) == 0;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}
