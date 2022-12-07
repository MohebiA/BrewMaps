package com.techelevator.model;

public class BrewerResults {
    private String id;
    private String name;
    double distance;
    String url;
    String description;

    public BrewerResults() {
    }

    public BrewerResults(String id, String name, double distance, String url, String description) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.url = url;
        this.description = description;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "Brewery='" + name + "is " + distance +" miles away.\n"+
                "Website:" + url + ";\n" +
                "Brewery Description:" + description + "\n";
    }
}