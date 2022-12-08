package com.techelevator.services;
import com.techelevator.model.*;
import com.techelevator.model.APIBeerDatum.BeerRoot;

import java.util.List;

public interface BreweryDetails {

    BreweryDetails[] getAllBreweries();

    BrewerDetails getBrewery(String id);

    BeerDetails getBeerById(String id);

    BeerRoot getBreweryBeerList(String id);

    List<BeerList> getBeerListByBrewery(String id);

    List<BrewerResults> getLongLatFromZip(double latitude, double longitude, int search_radius);

    Brewer getBreweryAndBeer(String id);


}
