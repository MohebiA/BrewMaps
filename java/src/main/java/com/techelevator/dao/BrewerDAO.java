package com.techelevator.dao;

import com.techelevator.model.Brewer;
import com.techelevator.model.BrewerDetails;
import com.techelevator.model.BrewerResults;

import java.util.List;

public interface BrewerDAO {

//    BrewerDetails getBrewerById(String id);
    List<BrewerResults> getAllBrewers(double latitude, double longitude, int radius);
    Brewer getBrewerByBreweryId(int id);
    int addBrewery (Brewer brewer);
    boolean deleteBrewery (String id);
    Brewer getBrewerByApiId(String id);
    int apiBreweryExistsInJdbc(String id);

}
