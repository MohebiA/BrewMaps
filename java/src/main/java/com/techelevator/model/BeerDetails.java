package com.techelevator.model;

public class BeerDetails {
    int id;
    String name;
    String style;
    String description;
    String imgUrl;
    int abv;
    int ibu;
    boolean beenRemoved;
    int breweryId;
    //BrewerDetails brewer = new BrewerDetails();

    public BeerDetails (){};

    public BeerDetails(int id, String name, String style, String description, String imgUrl, int abv, int ibu, boolean beenRemoved, int breweryId) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.description = description;
        this.imgUrl = imgUrl;
        this.abv = abv;
        this.ibu = ibu;
        this.beenRemoved = beenRemoved;
        this.breweryId = breweryId;
    }

    public boolean isBeenRemoved() {
        return beenRemoved;
    }

    public void setBeenRemoved(boolean beenRemoved) {
        this.beenRemoved = beenRemoved;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAbv() {
        return abv;
    }

    public void setAbv(int abv) {
        this.abv = abv;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }
}

