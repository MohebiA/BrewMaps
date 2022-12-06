package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDAO {
    Reviews getReviewById(int id);
    List<Reviews> getAllReviewsForBeer (int beerId);
    List<Reviews> getAllReviewsForBrewery (int breweryId);
    void addReview (Reviews review);


}
