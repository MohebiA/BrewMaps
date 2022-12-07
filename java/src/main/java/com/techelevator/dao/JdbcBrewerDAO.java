package com.techelevator.dao;

import com.techelevator.model.BrewerDetails;
import com.techelevator.model.ZipLongLat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBrewerDAO implements BrewerDAO {

    private JdbcTemplate jdbcTemplate;

    private ZipLongLat zipLongLat;

    public JdbcBrewerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BrewerDetails getBrewerById(String id) {
        return null;
    }

    @Override
    public List<BrewerDetails> getAllBrewers(double latitude, double longitude, int radius) {
        List<BrewerDetails> listOfBreweries = new ArrayList<>();
       double latAdjustment = zipLongLat.zipToLat(latitude, radius);
       double lonAdjustment = zipLongLat.zipToLon(longitude, radius);

       String sql = "select * from brewery where (latitude between ? and ?) and (longitude between ? and ?);";

        return listOfBreweries;
    }




    @Override
    public void addBrewery(BrewerDetails breweryId) {

    }

    @Override
    public void deleteBrewery(BrewerDetails breweryId) {

    }
}
