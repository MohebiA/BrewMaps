package com.techelevator.model;

public class ZipLongLat {
    private int zip;
    private String name;
    private double lat;
    private double lon;
    private String country;

    public ZipLongLat() {
    }

    public ZipLongLat(int zip, String name, double lat, double lon, String country) {
        this.zip = zip;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public double zipToLat(int radius) {
       double latRadius = (0.0145 * radius)/2;
       return latRadius;
    }

    public double zipToLon(int radius) {
          double lonRadius = (0.0183 * radius)/2;
        return lonRadius;
    }
}
