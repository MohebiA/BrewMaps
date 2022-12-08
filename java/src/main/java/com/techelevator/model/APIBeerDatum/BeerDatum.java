package com.techelevator.model.APIBeerDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerDatum {
    @JsonProperty("id")
    String id;
    public String getId() {
        return this.id; }
    public void setId(String id) {
        this.id = id; }


    @JsonProperty("name")
    String name;
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }

    @JsonProperty("style")
    String style;
    public String getStyle() {
        return this.style; }
    public void setStyle(String style) {
        this.style = style; }

}

