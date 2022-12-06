package com.techelevator.model;

public class Datum {
    public Location location;
    public Distance distance;
    public Brewer brewer;

    public Datum() {}

    public Datum(Location location, Distance distance, Brewer brewer) {
        this.location = location;
        this.distance = distance;
        this.brewer = brewer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }
}
