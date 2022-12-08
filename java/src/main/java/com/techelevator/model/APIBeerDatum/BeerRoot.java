package com.techelevator.model.APIBeerDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

    public class BeerRoot {
        @JsonProperty("object")
        String object;
        public String getObject() {
            return this.object; }
        public void setObject(String object) {
            this.object = object; }

        @JsonProperty("url")
        String url;
        public String getUrl() {
            return this.url; }
        public void setUrl(String url) {
            this.url = url; }

        @JsonProperty("has_more")
        boolean has_more;
        public boolean getHas_more() {
            return this.has_more; }
        public void setHas_more(boolean has_more) {
            this.has_more = has_more; }

        @JsonProperty("brewer")
        BeerBrewer brewer;
        public BeerBrewer getBrewer() {
            return this.brewer; }
        public void setBrewer(BeerBrewer brewer) {
            this.brewer = brewer; }

        @JsonProperty("data")
        ArrayList<BeerDatum> data;
        public ArrayList<BeerDatum> getData() {
            return this.data; }
        public void setData(ArrayList<BeerDatum> data) {
            this.data = data; }

    }
