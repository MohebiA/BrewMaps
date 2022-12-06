package com.techelevator.model;

import java.util.ArrayList;

public class Root {
    public String object;
    public String url;
    public boolean has_more;
    public ArrayList<Datum> data;

    public Root() {}

    public Root(String object, String url, boolean has_more, ArrayList<Datum> data) {
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
}
