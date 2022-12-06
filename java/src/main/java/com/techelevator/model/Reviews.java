package com.techelevator.model;

public class Reviews {
     private int reviewId;
     private int rating;
     private String review ="";
     private int userId;
     private int breweryId;
     private int beerId;

     public Reviews (){}

    public Reviews(int reviewId, int rating, String review, int userId, int breweryId, int beerId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.review = review;
        this.userId = userId;
        this.breweryId = breweryId;
        this.beerId = beerId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }
}
