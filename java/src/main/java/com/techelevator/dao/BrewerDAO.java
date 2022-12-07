package com.techelevator.dao;

import com.techelevator.model.BrewerDetails;

import java.util.List;

public interface BrewerDAO {

    BrewerDetails getBrewerById(String id);
    List<BrewerDetails> getAllBrewers(double latitude, double longitude, int radius);
    void addBrewery (BrewerDetails breweryId);
    void deleteBrewery (BrewerDetails breweryId);

}
