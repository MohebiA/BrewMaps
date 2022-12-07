package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBeerDao implements BeerDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BeerDetails> getAllBeers() {
        List<BeerDetails> beerDetails = new ArrayList<>();

        String sql = "select beer_id, name, img_url, description, abv, beer_type, api_beer_id, brewery_id, been_removed from beer;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//      while (results.next()) {
//
//      }
        return null;
    }

    @Override
    public BeerDetails getBeerById(String id) {
        String sql = "select beer_id, name, img_url, description, abv, beer_type, api_beer_id, brewery_id, been_removed from beer WHERE beer_id = ?;";
    //    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return null;
    }

    @Override
    public int addBeer(BeerDetails beer) {

        String sql = "insert into beer (name, img_url, description, abv, beer_type, brewery_id, api_beer_id, been_removed) " +
       " values (?, ?, ?, ?, ?, ?, ?, ?) returning beer_id; ";
        Integer newBeerId = 0;
        try {

         newBeerId = jdbcTemplate.queryForObject(sql, Integer.class, beer.getName(), beer.getImgUrl(), beer.getDescription(), beer.getAbv(),
                 beer.getStyle(), beer.getBreweryId(), beer.getApiId(), beer.isBeenRemoved());

        }
        catch (ResourceAccessException rae){

        }
        return newBeerId;
    }

    @Override
    public void deleteBeer(int beerId) {

    }

    private BeerDetails mapRowToBeerDetails(SqlRowSet rs) {
        BeerDetails beer = new BeerDetails();

        return beer;
    }
}
