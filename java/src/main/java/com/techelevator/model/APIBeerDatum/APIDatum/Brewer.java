package com.techelevator.model.APIBeerDatum.APIDatum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewer {

        @JsonProperty("id")
        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String id;

        @JsonProperty("object")
        public String getObject() {
            return this.object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        String object;

        @JsonProperty("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @JsonProperty("description")
        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String description;

        @JsonProperty("short_description")
        public Object getShort_description() {
            return this.short_description;
        }

        public void setShort_description(Object short_description) {
            this.short_description = short_description;
        }

        Object short_description;

        @JsonProperty("url")
        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        String url;

        @JsonProperty("cb_verified")
        public boolean getCb_verified() {
            return this.cb_verified;
        }

        public void setCb_verified(boolean cb_verified) {
            this.cb_verified = cb_verified;
        }

        boolean cb_verified;

        @JsonProperty("brewer_verified")
        public boolean getBrewer_verified() {
            return this.brewer_verified;
        }

        public void setBrewer_verified(boolean brewer_verified) {
            this.brewer_verified = brewer_verified;
        }

        boolean brewer_verified;

        @JsonProperty("facebook_url")
        public String getFacebook_url() {
            return this.facebook_url;
        }

        public void setFacebook_url(String facebook_url) {
            this.facebook_url = facebook_url;
        }

        String facebook_url;

        @JsonProperty("twitter_url")
        public String getTwitter_url() {
            return this.twitter_url;
        }

        public void setTwitter_url(String twitter_url) {
            this.twitter_url = twitter_url;
        }

        String twitter_url;

        @JsonProperty("instagram_url")
        public String getInstagram_url() {
            return this.instagram_url;
        }

        public void setInstagram_url(String instagram_url) {
            this.instagram_url = instagram_url;
        }

        String instagram_url;
    }
