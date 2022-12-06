package com.techelevator.model;

public class BeerDetails {
    String id;
    String name;
    String style;
    String description;
    int abv;
    int ibu;
    BrewerDetails brewer = new BrewerDetails();

    public BeerDetails (){};

    public BeerDetails(String id, String name, String style, String description, int abv, int ibu, BrewerDetails brewer) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.description = description;
        this.abv = abv;
        this.ibu = ibu;
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

    public BrewerDetails getBrewer() {
        return brewer;
    }

    public void setBrewer(BrewerDetails brewer) {
        this.brewer = brewer;
    }
}

