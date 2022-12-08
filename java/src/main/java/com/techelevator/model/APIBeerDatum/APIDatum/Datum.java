package com.techelevator.model.APIBeerDatum.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {
    @JsonProperty("location")
    Location location;

    @JsonProperty("distance")
    Distance distance;

    @JsonProperty("brewer")
    Brewer brewer;

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Distance getDistance() {
        return this.distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Brewer getBrewer() {
        return this.brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

}