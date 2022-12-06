package com.techelevator.model;

public class BrewerDetails {

        String id;
        String object;
        String name;
        String url;
        String facebookUrl;
        String twitterUrl;
        String instagramUrl;

        public BrewerDetails(){};

        public BrewerDetails(String id, String object, String name, String url, String facebookUrl, String twitterUrl, String instagramUrl) {
            this.id = id;
            this.object = object;
            this.name = name;
            this.url = url;
            this.facebookUrl = facebookUrl;
            this.twitterUrl = twitterUrl;
            this.instagramUrl = instagramUrl;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFacebookUrl() {
            return facebookUrl;
        }

        public void setFacebookUrl(String facebookUrl) {
            this.facebookUrl = facebookUrl;
        }

        public String getTwitterUrl() {
            return twitterUrl;
        }

        public void setTwitterUrl(String twitterUrl) {
            this.twitterUrl = twitterUrl;
        }

        public String getInstagramUrl() {
            return instagramUrl;
        }

        public void setInstagramUrl(String instagramUrl) {
            this.instagramUrl = instagramUrl;
        }
    }
