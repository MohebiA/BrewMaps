package com.techelevator.controller;
import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.JdbcBeerDao;
import com.techelevator.model.*;
import com.techelevator.model.APIBeerDatum.BeerRoot;
import com.techelevator.model.APIDatum.Root;
import com.techelevator.services.BreweryDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDetails breweryDetails;

    private BeerDAO beerDAO;

    public BreweryController(BreweryDetails breweryDetails, BeerDAO beerDAO){
        this.breweryDetails = breweryDetails;
        this.beerDAO = beerDAO;
    }

    @RequestMapping(path="/breweries", method = RequestMethod.GET)
    public BreweryDetails[] getAllBreweries(){
        return breweryDetails.getAllBreweries();
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
    public BrewerDetails getOneBrewery(@PathVariable String id){
        return breweryDetails.getBrewery(id);
    }

//    //TODO lat and long need to be zip
//    @RequestMapping(path="/location/nearby", method = RequestMethod.GET)
//    public List<BrewerResults> getBreweryByLocation(@RequestParam float latitude, @RequestParam float longitude, @RequestParam int search_radius){
//        List<BrewerResults> result = null;
//        result = breweryDetails.getBreweryByLocation(latitude, longitude, search_radius);
//        return result;
//    }


    //TODO this one works - DONT DELETE
//    @RequestMapping(path="/brewery/{id}/beerlist", method = RequestMethod.GET)
//    public BeerRoot getBreweryBeerList(@PathVariable String id){
//        BeerRoot result = null;
//        result = breweryDetails.getBeerListByBrewery(id);
//        return result;
//    }

    @RequestMapping(path="/brewery/{id}/beerlist", method = RequestMethod.GET)
    public List<BeerList> getBreweryBeerList(@PathVariable String id){
        List<BeerList> result = null;
        result = breweryDetails.getBeerListByBrewery(id);
        return result;
    }

    @RequestMapping(path="/beer/{id}", method = RequestMethod.GET)
    public BeerDetails getBeerById(@PathVariable String id){
        return breweryDetails.getBeerById(id);
    }

    //TODO id shouldn't be in the path since we won't know the ID if its not in the API
    @RequestMapping(path="/brewery/{id}/addbeer", method = RequestMethod.POST)
    public boolean addBeer(@RequestBody BeerDetails beer) {
        return beerDAO.addBeer(beer) > 0;
    }

    //TODO - added 12-06 - added zipcode lookup
    @RequestMapping(path="/brewery/find", method = RequestMethod.GET)
    public List<BrewerResults> getBreweryByZip(@RequestParam int zip, @RequestParam int search_radius) {
        List<BrewerResults> listOfBreweries = new ArrayList<>();
        listOfBreweries = breweryDetails.getLongLatFromZip(zip, search_radius);
        return listOfBreweries;
    }


}