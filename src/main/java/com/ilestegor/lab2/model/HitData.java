package com.ilestegor.lab2.model;

import java.util.Date;

public class HitData {
    private final Coordinates coordinates;
    private final String currentTime;
    private final double executionTime;
    private final String hitType;

    public HitData(Coordinates coordinates, String currentTime, double executionTime, String hitType) {
        this.coordinates = coordinates;
        this.currentTime = currentTime;
        this.executionTime = executionTime;
        this.hitType = hitType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public String getHitType() {
        return hitType;
    }

    @Override
    public String toString() {
        return "HitData{" +
                "coordinates=" + coordinates.getX() + " " + coordinates.getY() + " " + coordinates.getR() +
                ", currentTime=" + currentTime +
                ", executionTime=" + executionTime +
                ", hitType='" + hitType + '\'' +
                '}';
    }
}
