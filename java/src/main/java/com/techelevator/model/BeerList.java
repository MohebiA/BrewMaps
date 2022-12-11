package com.techelevator.model;

import java.util.List;

public class BeerList {
    private String id;
    private String name;
    private String style;
    double avgRating;

    public BeerList(){}

    public BeerList(String id, String name, String style, double avgRating) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.avgRating = avgRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public String toString() {
        return name + "\n"+ style;
    }
}
