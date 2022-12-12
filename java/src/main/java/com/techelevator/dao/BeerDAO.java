package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import com.techelevator.model.BeerList;
import com.techelevator.model.BeerListDetails;
import com.techelevator.model.Brewer;

import java.util.List;

public interface BeerDAO {

    List<BeerList> getBreweryBeerByBreweryId(int id);

    BeerDetails getBeerByBeerId(int id);

    int addBeer(BeerDetails beer, int breweryId);

    boolean updateBeer(BeerDetails beer, int beerId);

    boolean deleteBeer(String beerId);

    BeerDetails getBeerByAPIBeerId(String id);

    int apiBeerExistsInJdbc(String id);

    List<BeerList> checkForDeletedBeers(Brewer brewer);

    List<BeerList> getAvgRatingList(List<BeerList> beerList);

}
