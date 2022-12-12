package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import com.techelevator.model.BeerList;
import com.techelevator.model.Brewer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.sql.ResultSet;
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

        String sql = "select * from beer WHERE brewery_id = ? AND (api_beer_id IS NULL OR api_beer_id = '') AND been_removed = false;";
        String avgSql = "SELECT AVG(rating) AS average FROM reviews WHERE beer_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            BeerList currentBeer = mapRowToBeerList(results);
            Double avgRate = jdbcTemplate.queryForObject(avgSql, Double.class, Integer.parseInt(currentBeer.getId()));
            currentBeer.setAvgRating((avgRate == null) ? 0 : avgRate);
            beerDetails.add(currentBeer);
        }
        return beerDetails;
    }

    @Override
    public List<BeerList> getAvgRatingList(List<BeerList> beerList) {
        List<BeerList> beerAvgList = beerList;
        for(BeerList beer : beerAvgList) {
            int beerId = (apiBeerExistsInJdbc(beer.getId()));
            String sql = "select * from beer WHERE api_beer_id = ? AND been_removed = false;";
            String avgSql = "SELECT AVG(rating) AS average FROM reviews WHERE beer_id = ?;";

            if (beerId > 0) {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beer.getId());
                while (results.next()) {
               //     BeerList currentBeer = mapRowToAvgApiBeerList(results);
                    Double avgRate = jdbcTemplate.queryForObject(avgSql, Double.class, beerId);
                    beer.setAvgRating((avgRate == null) ? 0 : avgRate);
                    //beerAvgList.add(beer);
                }
            }
        }
        return beerAvgList;
        }


    @Override
    public BeerDetails getBeerByBeerId(int id) {
        String sql = "select * from beer WHERE beer_id = ?;";
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
                 beer.getStyle(), breweryId, (beer.getApiId()=="")? null : beer.getApiId(), beer.isBeenRemoved());

        }
        catch (ResourceAccessException rae){

        }
        return newBeerId;
    }

    @Override
    public boolean updateBeer(BeerDetails beer, int beerId){

        try {
            String sql = "UPDATE beer set name = ?, img_url = ?, description = ?, abv = ?, beer_type = ?, been_removed = ? " +
                    "WHERE beer_id = ?;";
            jdbcTemplate.update(sql, beer.getName(), beer.getImgUrl(), beer.getDescription(), beer.getAbv(),
                    beer.getStyle(), beer.isBeenRemoved(), beerId);
            return true;
        }catch (ResourceAccessException e){
            return false;
        }

    }

    @Override
    public boolean deleteBeer(String beerId) {
        try {
            if(beerId.length() > 14) {
                String sql = "UPDATE beer set been_removed = true where api_beer_id = ?;";
                jdbcTemplate.update(sql, beerId);
            }
            else {
                String sql = "UPDATE beer set been_removed = true where beer_id = ?;";

                jdbcTemplate.update(sql, Integer.parseInt(beerId));
            }
            return true;
        }
        catch (ResourceAccessException e){
            return false;
        }
    }

    public List<BeerList> checkForDeletedBeers(Brewer brewer){
        List<BeerList> currentBrewerList = brewer.getBeerList();
//        List<BeerList> replaceBeerList = new ArrayList<>();

        String sql = "SELECT * FROM beer WHERE api_beer_id = ?;";

        for(int i = 0; i < currentBrewerList.size(); i++){
            BeerList beer = currentBrewerList.get(i);
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, beer.getId());
            if(result.next()){
                BeerDetails beerDetails = mapRowToBeerDetails(result);
                if (beerDetails.isBeenRemoved()) {
                    String id = beer.getId();
                    currentBrewerList.remove(i);
                }
            }
        }
        return currentBrewerList;
    }

    public int apiBeerExistsInJdbc(String id){
        int beer_id = 0;
        String sql = "SELECT * FROM beer WHERE api_beer_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            beer_id = mapRowToBeerDetails(result).getId();
        }
        return beer_id;
    }

    private BeerList mapRowToBeerList(SqlRowSet result){
        BeerList bld = new BeerList();

        bld.setId(result.getString("beer_id"));
        bld.setName(result.getString("name"));
        bld.setStyle(result.getString("beer_type"));

        return bld;
    }

    private BeerList mapRowToAvgApiBeerList(SqlRowSet result){
        BeerList bld = new BeerList();

        bld.setId(result.getString("api_beer_id"));
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

    private double mapAvgToRow(SqlRowSet rowSet){
        BeerList beerList = new BeerList();
        beerList.setAvgRating(rowSet.getDouble("average"));

        return beerList.getAvgRating();

    }

//    private boolean mapRowToDeleted(SqlRowSet result){
//        BeerDetails beer = new BeerDetails();
//
//        beer.setId(result.getInt("beer_id"));
//        beer.setName(result.getString("name"));
//        beer.setImgUrl(result.getString("img_url"));
//        beer.setDescription(result.getString("description"));
//        beer.setAbv(result.getDouble("abv"));
//        beer.setStyle(result.getString("beer_type"));
//        beer.setBreweryId(result.getInt("brewery_id"));
//        beer.setApiId(result.getString("api_beer_id"));
//        beer.setBeenRemoved(result.getBoolean("been_removed"));
//
//        return beer.isBeenRemoved();
//    }
}


