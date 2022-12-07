package com.techelevator.model.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root {

        @JsonProperty("object")
        String object;

        @JsonProperty("url")
        String url;

        @JsonProperty("has_more")
        boolean has_more;

        @JsonProperty("data")
        ArrayList<Datum> data;

        public Root(){}

        public String getObject() {
            return this.object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean getHas_more() {
            return this.has_more;
        }

        public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

        public ArrayList<Datum> getData() {
            return this.data;
        }

        public void setData(ArrayList<Datum> data) {
            this.data = data;
        }

    }

