package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JdbcReviewsDao implements ReviewsDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reviews getReviewById(int id) {
        return null;
    }

    @Override
    public List<Reviews> getAllReviewsForBeer(int beerId) {
        return null;
    }

    @Override
    public List<Reviews> getAllReviewsForBrewery(int breweryId) {
        return null;
    }

    @Override
    public int addReview(Reviews review, int beerId, int userId, int jdbcBreweryId) {
        int reviewId = 0;
        String sql = "Insert into reviews (rating, review, user_id, brewery_id, beer_id) values (?, ?, ?, ?, ?) returning review_id;";

        reviewId = jdbcTemplate.queryForObject(sql, Integer.class, review.getRating(), review.getReview(), userId ,jdbcBreweryId , beerId);


        return reviewId;
    }
}
