package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBrewerDAO implements BrewerDAO {

    private JdbcTemplate jdbcTemplate;

    private BeerDAO beerDAO;
    private ZipLongLat zipLongLat = new ZipLongLat();

    public JdbcBrewerDAO(JdbcTemplate jdbcTemplate, BeerDAO beerDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.beerDAO = beerDAO;
    }

    @Override
    public Brewer getBrewerByBreweryId(int id) {
        Brewer brewery = new Brewer();

        String sql = "SELECT * FROM brewery WHERE brewery_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            brewery = mapSingleBreweryToRow(result);
        }

        //TODO get beerList
        List<BeerList> beerList = beerDAO.getBreweryBeerByBreweryId(id);
        brewery.setBeerList(beerList);
        return brewery;
    }

    @Override
    public List<BrewerResults> getAllBrewers(double latitude, double longitude, int radius) {
        List<BrewerResults> listOfBreweries = new ArrayList<>();
        double latAdjustment = zipLongLat.zipToLat(radius);
        double lonAdjustment = zipLongLat.zipToLon(radius);

        double smallLatitude = latitude - latAdjustment;
        double largerLatitude = latitude + latAdjustment;

        double smallLongitude = longitude - lonAdjustment;
        double largerLongitude = longitude + lonAdjustment;


       String sql = "select * from brewery where (latitude between ? and ?) and (longitude between ? and ?);";

       try {
           SqlRowSet result = jdbcTemplate.queryForRowSet(sql, smallLatitude, largerLatitude, smallLongitude, largerLongitude);
           while (result.next()) {
               listOfBreweries.add(mapResultsToRow(result, latitude, longitude));
           }
       } catch (ResourceAccessException e) {
           System.out.println(e.getMessage());
       }
        return listOfBreweries;
    }

    @Override
    public void addBrewery(BrewerDetails breweryId) {
    }

    @Override
    public void deleteBrewery(BrewerDetails breweryId) {
    }

    //HELPER METHODS
    private BrewerResults mapResultsToRow(SqlRowSet result, double lat, double lon){
        BrewerResults brewerResults = new BrewerResults();

        brewerResults.setId(String.valueOf(result.getInt("brewery_id")));
        brewerResults.setName(result.getString("name"));
        brewerResults.setLat(result.getDouble("latitude"));
        brewerResults.setLon(result.getDouble("longitude"));
        double distance = distanceCalculator(brewerResults.getLat(), brewerResults.getLon(), lat, lon);
        brewerResults.setDistance(distance);
        brewerResults.setUrl(result.getString("brewery_img_url"));
        brewerResults.setDescription(result.getString("brewery_history"));

        return brewerResults;
    }

    private Brewer mapSingleBreweryToRow(SqlRowSet result){
        Brewer brewery = new Brewer();

        brewery.setId(result.getInt("brewery_id"));
        brewery.setName(result.getString("name"));
        brewery.setDescription(result.getString("brewery_history"));
        brewery.setUrl(result.getString("brewery_url"));

        return brewery;
    }

    //lat&lon1 are search zip, lat&lon2 are the brewery zip
    private double distanceCalculator(double lat1, double lon1, double lat2, double lon2){
        {
            if ((lat1 == lat2) && (lon1 == lon2)) {
                return 0;
            }
            else {
                double theta = lon1 - lon2;
                double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;

                //TODO fix rounding errors
                double distance = Math.round(dist *10 ) / 10;

                return (distance);
            }
        }

    }
}
