package com.techelevator.model.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("id")
    String id;

    @JsonProperty("object")
    String object;

    @JsonProperty("name")
    String name;

    @JsonProperty("brewer_id")
    String brewer_id;

    @JsonProperty("url")
    Object url;

    @JsonProperty("country_code")
    String country_code;

    @JsonProperty("country_short_name")
    String country_short_name;

    @JsonProperty("latitude")
    double latitude;

    @JsonProperty("longitude")
    double longitude;

    @JsonProperty("telephone")
    long telephone;

    @JsonProperty("address")
    Address address;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return this.object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewer_id() {
        return this.brewer_id;
    }

    public void setBrewer_id(String brewer_id) {
        this.brewer_id = brewer_id;
    }

    public Object getUrl() {
        return this.url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_short_name() {
        return this.country_short_name;
    }

    public void setCountry_short_name(String country_short_name) {
        this.country_short_name = country_short_name;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getTelephone() {
        return this.telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}

