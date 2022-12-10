package com.techelevator.model;

public class BrewerLocation {
    Address address;
    Brewer brewer;
    String id;
    String name;
    String url;
    String countryCode;
    double latitude;
    double longitdue;

    public BrewerLocation() {}

    public BrewerLocation(Address address, Brewer brewer, String id, String name, String url, String countryCode, double latitude, double longitdue) {
        this.address = address;
        this.brewer = brewer;
        this.id = id;
        this.name = name;
        this.url = url;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitdue = longitdue;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitdue() {
        return longitdue;
    }

    public void setLongitdue(double longitdue) {
        this.longitdue = longitdue;
    }
}
