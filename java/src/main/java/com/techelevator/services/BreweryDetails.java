package com.techelevator.services;
import com.techelevator.model.*;
import com.techelevator.model.APIBeerDatum.BeerRoot;
import com.techelevator.model.APIDatum.Root;

import java.util.List;

public interface BreweryDetails {

    BreweryDetails[] getAllBreweries();

    BrewerDetails getBrewery(String id);

    BeerDetails getBeerById(String id);

    List<BrewerResults> getBreweryByLocation(float latitude, float longitude, int search_radius);

    BeerRoot getBreweryBeerList(String id);

    List<BeerList> getBeerListByBrewery(String id);

//    Root getBreweryByLocation(float latitude, float longitude, int search_radius);


}
