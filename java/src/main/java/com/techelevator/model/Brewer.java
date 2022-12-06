package com.techelevator.model;

public class Brewer {
    public String id;
    public String object;
    public String name;
    public Object description;
    public Object short_description;
    public String url;
    public boolean cb_verified;
    public boolean brewer_verified;
    public String facebook_url;
    public String twitter_url;
    public String instagram_url;

    public Brewer() {}

    public Brewer(String id, String object, String name, Object description, Object short_description, String url, boolean cb_verified, boolean brewer_verified, String facebook_url, String twitter_url, String instagram_url) {
        this.id = id;
        this.object = object;
        this.name = name;
        this.description = description;
        this.short_description = short_description;
        this.url = url;
        this.cb_verified = cb_verified;
        this.brewer_verified = brewer_verified;
        this.facebook_url = facebook_url;
        this.twitter_url = twitter_url;
        this.instagram_url = instagram_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getShort_description() {
        return short_description;
    }

    public void setShort_description(Object short_description) {
        this.short_description = short_description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCb_verified() {
        return cb_verified;
    }

    public void setCb_verified(boolean cb_verified) {
        this.cb_verified = cb_verified;
    }

    public boolean isBrewer_verified() {
        return brewer_verified;
    }

    public void setBrewer_verified(boolean brewer_verified) {
        this.brewer_verified = brewer_verified;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getTwitter_url() {
        return twitter_url;
    }

    public void setTwitter_url(String twitter_url) {
        this.twitter_url = twitter_url;
    }

    public String getInstagram_url() {
        return instagram_url;
    }

    public void setInstagram_url(String instagram_url) {
        this.instagram_url = instagram_url;
    }
}
