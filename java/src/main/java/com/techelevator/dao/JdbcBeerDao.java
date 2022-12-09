package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import com.techelevator.model.BeerList;
import com.techelevator.model.BeerListDetails;
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
    public List<BeerList> getBreweryBeerByBreweryId(int id) {
        List<BeerList> beerDetails = new ArrayList<>();

        String sql = "select * from beer WHERE brewery_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            beerDetails.add(mapRowToBeerList(results));
        }
        return beerDetails;
    }

    @Override
    public BeerDetails getBeerByBeerId(int id) {
        String sql = "select beer_id, name, img_url, description, abv, beer_type, api_beer_id, brewery_id, been_removed from beer WHERE beer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeerDetails(results);
        } else {
            return null;
        }
    }

    public BeerDetails getBeerByAPIBeerId(String id) {
        String sql = "select * FROM beer WHERE api_beer_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToBeerDetails(results);
        } else {
            return null;
        }
    }

    @Override
    public int addBeer(BeerDetails beer, int breweryId) {

        String sql = "insert into beer (name, img_url, description, abv, beer_type, brewery_id, api_beer_id, been_removed) " +
       " values (?, ?, ?, ?, ?, ?, ?, ?) returning beer_id; ";
        Integer newBeerId = 0;
        try {

         newBeerId = jdbcTemplate.queryForObject(sql, Integer.class, beer.getName(), beer.getImgUrl(), beer.getDescription(), beer.getAbv(),
                 beer.getStyle(), breweryId, beer.getApiId(), beer.isBeenRemoved());

        }
        catch (ResourceAccessException rae){

        }
        return newBeerId;
    }

    @Override
    public void deleteBeer(int beerId) {

    }

    private BeerList mapRowToBeerList(SqlRowSet result){
        BeerList bld = new BeerList();

        bld.setId(result.getString("beer_id"));
        bld.setName(result.getString("name"));
        bld.setStyle(result.getString("beer_type"));

        return bld;
    }

    private BeerDetails mapRowToBeerDetails(SqlRowSet result) {
        BeerDetails beer = new BeerDetails();
        beer.setId(result.getInt("beer_id"));
        beer.setName(result.getString("name"));
        beer.setImgUrl(result.getString("img_url"));
        beer.setDescription(result.getString("description"));
        beer.setAbv(result.getDouble("abv"));
        beer.setStyle(result.getString("beer_type"));
        beer.setBreweryId(result.getInt("brewery_id"));
        beer.setApiId(result.getString("api_beer_id"));
        beer.setBeenRemoved(result.getBoolean("been_removed"));
        return beer;
    }


}


