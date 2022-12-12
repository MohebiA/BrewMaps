package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.services.BreweryDetails;
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
    private UserDao userDao;
    private ZipLongLat zipLongLat = new ZipLongLat();

    public JdbcBrewerDAO(JdbcTemplate jdbcTemplate, BeerDAO beerDAO, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.beerDAO = beerDAO;
        this.userDao = userDao;

    }


    @Override
    public Brewer getBrewerByUserId(int id) {
        Brewer brewery = null;

        String sql = "SELECT * FROM brewery WHERE user_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()) {
            brewery = mapSingleBreweryToRow(result);

        }
        return brewery;
    }

    @Override
    public Brewer getBrewerByBreweryId(int id) {
//        Brewer brewery = new Brewer();
        Brewer brewery = null;

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

    public Brewer getBrewerByApiId(String id) {
        Brewer brewery = null;

        String sql = "SELECT * FROM brewery WHERE api_brewery_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()) {
            brewery = mapSingleBreweryToRow(result);
            List<BeerList> beerList = beerDAO.getBreweryBeerByBreweryId(brewery.getBrewerId());
            brewery.setBeerList(beerList);
            return brewery;
        } else {
            return null;
        }
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


       String sql = "select * from brewery where (latitude between ? and ?) and (longitude between ? and ?) and api_brewery_id is NULL;";

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
    public int addBrewery(Brewer brewer, int userId) {
//        Brewer brewery = brewer;
//        String apiId = brewer.getApiBreweryId();
//        int brewerId = (brewer.getUserId() == 0) ? userId : userDao.findIdByUsername(brewer.getName());

        int value = 0;

        String sql = "insert into brewery (name, user_id, phone_num, address_1, address_2, city, state, zip, hours, brewery_img_url," +
                " brewery_url, brewery_history, api_brewery_id, longitude, latitude, is_active, been_removed) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning brewery_id;";

        try {
            value = jdbcTemplate.queryForObject(sql, Integer.class, brewer.getName(),
                    userId, brewer.getPhoneNumber(), brewer.getAddress1(), brewer.getAddress2(), brewer.getCity(),
                    brewer.getState(), brewer.getZip(), brewer.getHours(), brewer.getImgUrl(), brewer.getUrl(),
                    brewer.getHistory(), brewer.getApiBreweryId(), brewer.getLongitude(), brewer.getLatitude(), brewer.isActive(), brewer.isBeenRemoved());
        }
        catch (ResourceAccessException e){
            System.out.println("nope");
        }
        return value;
    }

    @Override
    public boolean deleteBrewery(String id) {
        try {
            if(id.length() > 14) {
                String sql = "UPDATE brewery set is_active = false, been_removed = true where api_brewery_id = ?;";
                jdbcTemplate.update(sql, id);
            }
            else {
                String sql = "UPDATE brewery set is_active = false, been_removed = true where brewery_id = ?;";
                int breweryId = Integer.parseInt(id);
                jdbcTemplate.update(sql, breweryId);
            }
            return true;
        }
        catch (ResourceAccessException e){
            return false;
        }

    }

    public int apiBreweryExistsInJdbc(String id){
        int brewery_id = 0;
        String sql = "SELECT * FROM brewery WHERE api_brewery_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            brewery_id = mapSingleBreweryToRow(result).getBrewerId();
        }
        return brewery_id;
    }

    public String getApiBreweryIdFromDatabase(int id){
        String brewery_id = null;
        String sql = "SELECT * FROM brewery WHERE brewery_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            brewery_id = mapRowToApiBrewery(result).getApiBreweryId();
        }
        return brewery_id;
    }

    public boolean updateBrewery(Brewer brewer, int id){
        try {
            String sql ="UPDATE brewery set name = ?, phone_num = ?, address_1 = ?, address_2 = ?, city = ?, state = ?, zip = ?, hours = ?, brewery_img_url = ?, " +
                    "brewery_url = ?, brewery_history = ?, longitude = ?, latitude = ?, is_active = ?, been_removed = ? WHERE brewery_id = ?;";
            jdbcTemplate.update(sql, brewer.getName(),
                    brewer.getPhoneNumber(), brewer.getAddress1(), brewer.getAddress2(), brewer.getCity(),
                    brewer.getState(), brewer.getZip(), brewer.getHours(), brewer.getImgUrl(), brewer.getUrl(),
                    brewer.getHistory(), brewer.getLongitude(), brewer.getLatitude(), brewer.isActive(), brewer.isBeenRemoved(), id);
            return true;
        }
        catch (ResourceAccessException e){
            return false;
        }
    }

    //HELPER METHODS
    private BrewerResults mapResultsToRow(SqlRowSet result, double lat, double lon){
        BrewerResults brewerResults = new BrewerResults();
        BrewerResults brewerResults1 = new BrewerResults();

        brewerResults.setId(String.valueOf(result.getInt("brewery_id")));
        brewerResults1.setId(String.valueOf(result.getInt("api_brewery_id")));
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

        brewery.setBrewerId(result.getInt("brewery_id"));
        brewery.setUserId(result.getInt("user_id"));
        brewery.setName(result.getString("name"));
        brewery.setDescription(result.getString("brewery_history"));
        brewery.setUrl(result.getString("brewery_url"));

        return brewery;
    }

    private Brewer mapRowToApiBrewery(SqlRowSet result){
        Brewer brewery = new Brewer();

        brewery.setBrewerId(result.getInt("brewery_id"));
        brewery.setName(result.getString("name"));
        brewery.setDescription(result.getString("brewery_history"));
        brewery.setUrl(result.getString("brewery_url"));
        brewery.setApiBreweryId(result.getString("api_brewery_id"));;

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

    public void deleteLocationId () {
        String deleteSql = "DELETE FROM temp_location;";
        jdbcTemplate.update(deleteSql);
    }

    public void setLocationId (String locationId, String breweryId){
        String insertSql= "INSERT INTO temp_location (location_id, brewery_id) VALUES (?,?);";
        jdbcTemplate.update(insertSql, locationId, breweryId);
    }


}
