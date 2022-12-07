package com.techelevator.model.APIBeerDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

    public class BeerRoot {
        @JsonProperty("object")
        public String getObject() {
            return this.object; }
        public void setObject(String object) {
            this.object = object; }
        String object;
        @JsonProperty("url")
        public String getUrl() {
            return this.url; }
        public void setUrl(String url) {
            this.url = url; }
        String url;
        @JsonProperty("has_more")
        public boolean getHas_more() {
            return this.has_more; }
        public void setHas_more(boolean has_more) {
            this.has_more = has_more; }
        boolean has_more;
        @JsonProperty("brewer")
        public BeerBrewer getBrewer() {
            return this.brewer; }
        public void setBrewer(BeerBrewer brewer) {
            this.brewer = brewer; }
        BeerBrewer brewer;
        @JsonProperty("data")
        public ArrayList<BeerDatum> getData() {
            return this.data; }
        public void setData(ArrayList<BeerDatum> data) {
            this.data = data; }
        ArrayList<BeerDatum> data;
    }
