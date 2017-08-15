package com.example.luke.bitebox;

/**
 * Created by Luke on 11/08/2017.
 */

public class Rewards {

    String name;
    int pointsCost;

    public Rewards(String name, int pointsCost) {
        this.name = name;
        this.pointsCost = pointsCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointsCost() {
        return pointsCost;
    }

    public void setPointsCost(int pointsCost) {
        this.pointsCost = pointsCost;
    }
}
