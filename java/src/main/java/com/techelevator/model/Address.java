package com.techelevator.model;

public class Address {
    public String address1;
    public String address2;
    public String city;
    public String sub_code;
    public String state_short;
    public String state_long;
    public String zip5;
    public String zip4;

    public Address() {}

    public Address(String address1, String address2, String city, String sub_code, String state_short, String state_long, String zip5, String zip4) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.sub_code = sub_code;
        this.state_short = state_short;
        this.state_long = state_long;
        this.zip5 = zip5;
        this.zip4 = zip4;
    }

    public Object getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getState_short() {
        return state_short;
    }

    public void setState_short(String state_short) {
        this.state_short = state_short;
    }

    public String getState_long() {
        return state_long;
    }

    public void setState_long(String state_long) {
        this.state_long = state_long;
    }

    public String getZip5() {
        return zip5;
    }

    public void setZip5(String zip5) {
        this.zip5 = zip5;
    }

    public String getZip4() {
        return zip4;
    }

    public void setZip4(String zip4) {
        this.zip4 = zip4;
    }
}