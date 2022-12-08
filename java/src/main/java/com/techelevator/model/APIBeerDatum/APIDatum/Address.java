package com.techelevator.model.APIBeerDatum.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty("address1")
    Object address1;

    @JsonProperty("address2")
    String address2;

    @JsonProperty("city")
    String city;

    @JsonProperty("sub_code")
    String sub_code;

    @JsonProperty("state_short")
    String state_short;

    @JsonProperty("state_long")
    String state_long;

    @JsonProperty("zip4")
    int zip4;

    @JsonProperty("zip5")
    int zip5;

    public Object getAddress1() {return this.address1;}

    public void setAddress1(Object address1) {this.address1 = address1;}

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSub_code() {
        return this.sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getState_short() {
        return this.state_short;
    }

    public void setState_short(String state_short) {
        this.state_short = state_short;
    }

    public String getState_long() {
        return this.state_long;
    }

    public void setState_long(String state_long) {
        this.state_long = state_long;
    }

    public int getZip5() {
        return this.zip5;
    }

    public void setZip5(int zip5) {
        this.zip5 = zip5;
    }

    public int getZip4() {
        return this.zip4;
    }

    public void setZip4(int zip4) {
        this.zip4 = zip4;
    }


}
