package com.techelevator.model.APIBeerDatum.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Distance {
    @JsonProperty("distance")
    double distance;

    @JsonProperty("units")
    String units;

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getUnits() {
        return this.units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
