package com.techelevator.model;

public class BrewerResults {
    private String id;
    private String name;
    double distance;
    String url;
    String description;
    double lat;
    double lon;
    String address1;
    String address2;
    String city;
    String state;
    String zip;


    public BrewerResults() {
    }

    public BrewerResults(String id, String name, double distance, String url, String description, double lat, double lon, String address1, String address2, String city, String state, String zip) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.url = url;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return  "Brewery='" + name + "is " + distance +" miles away.\n"+
                "Website:" + url + ";\n" +
                "Brewery Description:" + description + "\n";
    }
}
