package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcReviewsDao implements ReviewsDAO {

    private BeerDAO beerDAO;

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(JdbcTemplate jdbcTemplate, BeerDAO beerDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.beerDAO = beerDAO;
    }

    @Override
    public Reviews getReviewById(int id) {
        Reviews review = new Reviews();

        String sql = "SELECT * FROM reviews WHERE review_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            review = mapRowToReviews(result);
        }

        return review;
    }

    @Override
    public List<Reviews> getAllReviewsForBeer(String beerId) {
        List<Reviews> reviews = new ArrayList<>();

        if(beerId.length() > 14){
            BeerDetails beerDetails = beerDAO.getBeerByAPIBeerId(beerId);
            if(beerDetails != null) {
                String sql = "select * from reviews where beer_id = ?;";

                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerDetails.getId());
                while (results.next()) {
                    reviews.add(mapRowToReviews(results));
                }
            }
        } else {

            String sql = "select * from reviews where beer_id = ?;";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Integer.parseInt(beerId));
            while(results.next()){
                reviews.add(mapRowToReviews(results));
            }
        }
        return reviews;
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

    //HELPER METHODS
    private Reviews mapRowToReviews(SqlRowSet result){
        Reviews reviews = new Reviews();

        reviews.setRating(result.getInt("rating"));
        reviews.setReview(result.getString("review"));
        reviews.setUserId(result.getInt("user_id"));
        reviews.setBreweryId(result.getInt("brewery_id"));
        reviews.setBeerId(result.getInt("beer_id"));

        return reviews;
    }
}
