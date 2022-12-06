package com.techelevator.model;

public class Location{
    public String id;
    public String object;
    public String name;
    public String brewer_id;
    public String url;
    public String country_code;
    public String country_short_name;
    public float latitude;
    public float longitude;
    public String telephone;
    public Address address;

    public Location() {}

    public Location(String id, String object, String name, String brewer_id, String url, String country_code, String country_short_name, float latitude, float longitude, String telephone, Address address) {
        this.id = id;
        this.object = object;
        this.name = name;
        this.brewer_id = brewer_id;
        this.url = url;
        this.country_code = country_code;
        this.country_short_name = country_short_name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.telephone = telephone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewer_id() {
        return brewer_id;
    }

    public void setBrewer_id(String brewer_id) {
        this.brewer_id = brewer_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_short_name() {
        return country_short_name;
    }

    public void setCountry_short_name(String country_short_name) {
        this.country_short_name = country_short_name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}