package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Brewer {
    private String brewerUsername;
    private String address1;
    private String address2;
    private String city;
    private String zip;
    private String state;
    private String hours;
    private String imgUrl;
    private String history;
    private double latitude;
    private double longitude;

    @JsonProperty("active")
    private boolean isActive;
    private boolean beenRemoved;
    private String phoneNumber;
    private int userId;
    private int brewerId;

    @JsonProperty ("id")
    @JsonAlias("apiBreweryId")
    private String apiBreweryId;
    private String object;
    private String name;
    private Object description;
    private Object short_description;
    private String url;
    private boolean cb_verified;
    private boolean brewer_verified;
    private String facebook_url;
    private String twitter_url;
    private String instagram_url;
    private List<BeerList> beerList;

    public Brewer() {}

    public Brewer(String brewerUsername, String address1, String address2, String city, String zip, String state, String hours, String imgUrl, String history,
                  double latitude, double longitude, boolean isActive, boolean beenRemoved, String phoneNumber, int userId, int brewerId,
                  String apiBreweryId, String object, String name, Object description, Object short_description, String url,
                  boolean cb_verified, boolean brewer_verified, String facebook_url, String twitter_url, String instagram_url, List<BeerList> beerList) {

        this.brewerUsername = brewerUsername;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.hours = hours;
        this.imgUrl = imgUrl;
        this.history = history;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActive = isActive;
        this.beenRemoved = beenRemoved;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
        this.brewerUsername = brewerUsername;
        this.brewerId = brewerId;
        this.apiBreweryId = apiBreweryId;
        this.object = object;
        this.name = name;
        this.description = description;
        this.short_description = short_description;
        this.url = url;
        this.cb_verified = cb_verified;
        this.brewer_verified = brewer_verified;
        this.facebook_url = facebook_url;
        this.twitter_url = twitter_url;
        this.instagram_url = instagram_url;
        this.beerList = beerList;
    }

    public String getBrewerUsername() {
        return brewerUsername;
    }

    public void setBrewerUsername(String brewerUsername) {
        this.brewerUsername = brewerUsername;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isBeenRemoved() {
        return beenRemoved;
    }

    public void setBeenRemoved(boolean beenRemoved) {
        this.beenRemoved = beenRemoved;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getShort_description() {
        return short_description;
    }

    public void setShort_description(Object short_description) {
        this.short_description = short_description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCb_verified() {
        return cb_verified;
    }

    public void setCb_verified(boolean cb_verified) {
        this.cb_verified = cb_verified;
    }

    public boolean isBrewer_verified() {
        return brewer_verified;
    }

    public void setBrewer_verified(boolean brewer_verified) {
        this.brewer_verified = brewer_verified;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getTwitter_url() {
        return twitter_url;
    }

    public void setTwitter_url(String twitter_url) {
        this.twitter_url = twitter_url;
    }

    public String getInstagram_url() {
        return instagram_url;
    }

    public void setInstagram_url(String instagram_url) {
        this.instagram_url = instagram_url;
    }

    @JsonProperty ("id")
    @JsonAlias("apiBreweryId")
    public String getApiBreweryId() {
        return apiBreweryId;
    }

    @JsonProperty ("id")
    @JsonAlias("apiBreweryId")
    public void setApiBreweryId(String apiBreweryId) {
        this.apiBreweryId = apiBreweryId;
    }

    public List<BeerList> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<BeerList> beerList) {
        this.beerList = beerList;
    }

}
