package com.techelevator.model.APIBeerDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerDatum {
    @JsonProperty("id")
    public String getId() {
        return this.id; }
    public void setId(String id) {
        this.id = id; }
    String id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("style")
    public String getStyle() {
        return this.style; }
    public void setStyle(String style) {
        this.style = style; }
    String style;
}

