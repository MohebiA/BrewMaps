package com.techelevator.dao;

import com.techelevator.model.BrewerDetails;
import com.techelevator.model.BrewerResults;

import java.util.List;

public interface BrewerDAO {

    BrewerDetails getBrewerById(String id);
    List<BrewerResults> getAllBrewers(double latitude, double longitude, int radius);
    void addBrewery (BrewerDetails breweryId);
    void deleteBrewery (BrewerDetails breweryId);

}
