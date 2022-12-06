package com.techelevator.dao;

import com.techelevator.model.BrewerDetails;

import java.util.List;

public interface BrewerDAO {

    BrewerDetails getBrewerById(String id);
    List<BrewerDetails> getAllBrewers();
    void addBrewery (BrewerDetails breweryId);
    void deleteBrewery (BrewerDetails breweryId);

}
