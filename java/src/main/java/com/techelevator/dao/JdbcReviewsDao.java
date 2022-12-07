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
    public void addReview(Reviews review) {

    }
}
