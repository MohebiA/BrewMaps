package com.techelevator.controller;
import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BrewerDAO;
import com.techelevator.model.*;
import com.techelevator.services.BreweryDetails;
import com.techelevator.services.LocationConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private LocationConverter locationConverter;

    private BreweryDetails breweryDetails;

    private BeerDAO beerDAO;

    private BrewerDAO brewerDAO;

    public BreweryController(BreweryDetails breweryDetails, BeerDAO beerDAO, LocationConverter locationConverter, BrewerDAO brewerDAO){
        this.breweryDetails = breweryDetails;
        this.beerDAO = beerDAO;
        this.locationConverter = locationConverter;
        this.brewerDAO = brewerDAO;
    }

    @RequestMapping(path="/breweries", method = RequestMethod.GET)
    public BreweryDetails[] getAllBreweries(){
        return breweryDetails.getAllBreweries();
    }

//    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
//    public BrewerDetails getOneBrewery(@PathVariable String id){
//        return breweryDetails.getBrewery(id);
//    }

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

//    @RequestMapping(path="/brewery/{id}/beerlist", method = RequestMethod.GET)
//    public List<BeerList> getBreweryBeerList(@PathVariable String id){
//        List<BeerList> result = null;
//        result = breweryDetails.getBeerListByBrewery(id);
//        return result;
//    }

//    @RequestMapping(path="/brewery/{id}/beerlist", method = RequestMethod.GET)
    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
    public Brewer getBreweryBeerList(@PathVariable String id){
        Brewer result = null;
        int length = id.length();
        if(id.length() > 14){
            result = breweryDetails.getBreweryAndBeer(id);
        }
        else{
            int intId = Integer.parseInt(id);
            result =  brewerDAO.getBrewerByBreweryId(intId);
        }

        return result;
    }

    @RequestMapping(path="/beer/{id}", method = RequestMethod.GET)
    public BeerDetails getBeerById(@PathVariable String id){
        BeerDetails beerDetails = new BeerDetails();
        beerDetails =  breweryDetails.getBeerById(id);
        return beerDetails;
    }

    //TODO id equals brewery id
    @RequestMapping(path="/brewery/{id}/addbeer", method = RequestMethod.POST)
    public boolean addBeer(@RequestBody BeerDetails beer) {
        return beerDAO.addBeer(beer) > 0;
    }

    @RequestMapping(path="/brewery/addbrewery", method = RequestMethod.POST)
    public boolean addBrewery(@RequestBody Brewer brewer) {
        return brewerDAO.addBrewery(brewer) > 0;
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.PUT)
    public boolean deleteBrewery(@PathVariable String id) {
        return brewerDAO.deleteBrewery(id);
    }

    //TODO - added 12-06 - added zipcode lookup
    @RequestMapping(path="/brewery/find", method = RequestMethod.GET)
    public List<BrewerResults> getBreweryByZip(@RequestParam int zip, @RequestParam int search_radius) {
        List<BrewerResults> listOfBreweries = new ArrayList<>();
        ZipLongLat zipLongLat = locationConverter.getCoordinates(zip);
        listOfBreweries = breweryDetails.getLongLatFromZip(zipLongLat.getLat(), zipLongLat.getLon(), search_radius);
        List<BrewerResults> jdbcBreweries = brewerDAO.getAllBrewers(zipLongLat.getLat(), zipLongLat.getLon(), search_radius);
        for(BrewerResults result : jdbcBreweries){
            listOfBreweries.add(result);
        }
         return listOfBreweries;
    }

}