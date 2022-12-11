package com.techelevator.model;

import java.util.List;

public class BeerList {
    private String id;
    private String name;
    private String style;
    List<Reviews> reviewList;

    public BeerList(){}

    public BeerList(String id, String name, String style, List<Reviews> reviewList) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.reviewList = reviewList;
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

    public List<Reviews> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Reviews> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return name + "\n"+ style;
    }
}
