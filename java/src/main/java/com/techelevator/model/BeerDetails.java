package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BeerDetails {
//    int beerId;

   //TODO: FIX THE VARIABLE JSON MAPPING ISSUE
    @JsonProperty("id")
    String apiId;

    int id;
    String name;

    @JsonProperty("beer_type")
    @JsonAlias("style")
    String style;

    String description;
    String imgUrl;
    double abv;
    int ibu;
    boolean beenRemoved;
    int breweryId;
    Brewer brewer;
    List<Reviews> reviews;


    //BrewerDetails brewer = new BrewerDetails();

    public BeerDetails (){};

    public BeerDetails(String apiId, int id, String name, String style, String description, String imgUrl, double abv, int ibu, boolean beenRemoved, int breweryId, Brewer brewer, List<Reviews> reviews) {

        this.apiId = apiId;
        this.id = id;
        this.name = name;
        this.style = style;
        this.description = description;
        this.imgUrl = imgUrl;
        this.abv = abv;
        this.ibu = ibu;
        this.beenRemoved = beenRemoved;
        this.breweryId = breweryId;
        this.brewer = brewer;
        this.reviews = reviews;
    }
    @JsonProperty("id")
    public String getApiId() {
        return apiId;
    }

    @JsonProperty("id")
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("beer_type")
    @JsonAlias("style")
    public String getStyle() {
        return style;
    }

    @JsonProperty("beer_type")
    @JsonAlias("style")
    public void setStyle(String style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public boolean isBeenRemoved() {
        return beenRemoved;
    }

    public void setBeenRemoved(boolean beenRemoved) {
        this.beenRemoved = beenRemoved;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}

