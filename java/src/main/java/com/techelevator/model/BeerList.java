package com.techelevator.model;

public class BeerList {
    private String id;
    private String name;
    private String style;

    public BeerList(){}

    public BeerList(String id, String name, String style) {
        this.id = id;
        this.name = name;
        this.style = style;
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

    @Override
    public String toString() {
        return name + "\n"+ style;
    }
}
