package com.techelevator.model;

import com.techelevator.model.APIDatum.Datum;

import java.util.ArrayList;

public class BreweryLocation {
    public String object;
    public String url;
    public boolean has_more;
    public ArrayList<Datum> data;

    public BreweryLocation() {}

    public BreweryLocation(String object, String url, boolean has_more, ArrayList<Datum> data) {
        this.object = object;
        this.url = url;
        this.has_more = has_more;
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
}
