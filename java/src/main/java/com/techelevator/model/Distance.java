package com.techelevator.model;

public class Distance {

    public float distance;
    public String units;

    public Distance (){};

    public Distance(float distance, String units) {
        this.distance = distance;
        this.units = units;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

