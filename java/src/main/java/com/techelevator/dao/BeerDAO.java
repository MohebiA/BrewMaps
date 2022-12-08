package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import com.techelevator.model.BeerList;
import com.techelevator.model.BeerListDetails;

import java.util.List;

public interface BeerDAO {

    List<BeerList> getBreweryBeerByBreweryId(int id);

    BeerDetails getBeerByBeerId(int id);

    int addBeer(BeerDetails beer);

    void deleteBeer(int beerId);

}
