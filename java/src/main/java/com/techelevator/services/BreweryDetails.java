package com.techelevator.services;
import com.techelevator.model.BeerDetails;
import com.techelevator.model.BrewerDetails;
import com.techelevator.model.BreweryLocation;

import java.util.List;

public interface BreweryDetails {

    BreweryDetails[] getAllBreweries();
    BrewerDetails getBrewery(String id);
    BreweryLocation[] getBreweryByLocation(float latitude, float longitude,int search_radius);
    BeerDetails getBeerById(String id);
    BreweryLocation[] getFilterBreweriesByLocation(float latitude, float longitude,int search_radius);


}
