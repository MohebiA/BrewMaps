package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDAO {
    Reviews getReviewById(int id);
    List<Reviews> getAllReviewsForBeer (int beerId);
    List<Reviews> getAllReviewsForBrewery (int breweryId);
    int addReview (Reviews review, int beerId, int userId, int jdbcBreweryId);


}
