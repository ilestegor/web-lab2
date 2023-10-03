package com.ilestegor.lab2.model;

public enum HitType {
    FIRST_AREA("1️⃣"),
    SECOND_AREA("2️⃣"),
    THIRD_AREA("3️⃣"),
    MISS("🤬"),
    WRONG_DATA("Not valid data received");
    private final String hitArea;

    HitType(String hitArea) {
        this.hitArea = hitArea;
    }

    public String getHitArea() {
        return hitArea;
    }
}
