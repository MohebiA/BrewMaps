package com.techelevator.model;

public class BeerListDetails {
    private int id;
    private String name;
    private String style;

    public BeerListDetails(){}

    public BeerListDetails(int id, String name, String style) {
        this.id = id;
        this.name = name;
        this.style = style;
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

    @Override
    public String toString() {
        return name + "\n"+ style;
    }
}
