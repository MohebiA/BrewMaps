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



    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
    public Brewer getBreweryBeerList(@PathVariable String id){
        Brewer result;
        if(id.length() > 14){
            result = brewerDAO.getBrewerByApiId(id);
            if(result == null){
                result = breweryDetails.getBreweryAndBeer(id);
            }
        }
        else{
            int intId = Integer.parseInt(id);
            result =  brewerDAO.getBrewerByBreweryId(intId);
        }
        return result;
    }

    @RequestMapping(path="/beer/{id}", method = RequestMethod.GET)
    public BeerDetails getBeerById(@PathVariable String id){
        BeerDetails result = new BeerDetails();

        if(id.length() > 14){
            result = beerDAO.getBeerByAPIBeerId(id);
            if(result == null){
                result =  breweryDetails.getBeerById(id);
            }
        }
        else{
            int intId = Integer.parseInt(id);
        }
        return result;
    }

    //TODO id equals brewery id
    @RequestMapping(path="/brewery/{id}/addbeer", method = RequestMethod.POST)
    public boolean addBeer(@PathVariable String id, @RequestBody BeerDetails beer) {

        int jdbcBreweryId;

        if(id.length() > 14){
            jdbcBreweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if(jdbcBreweryId == 0){
                Brewer brewery = breweryDetails.getBreweryAndBeer(id); //API CALL
                int newBreweryId = brewerDAO.addBrewery(brewery); //CREATES BREWERY IN POSTGRES
                return beerDAO.addBeer(beer, newBreweryId) > 0; //CREATES BEER
            } else {
                return beerDAO.addBeer(beer, jdbcBreweryId) >0;
            }
        }
        else{
            int intId = Integer.parseInt(id);
            return beerDAO.addBeer(beer, intId) > 0;
        }
    }

    @RequestMapping(path="/brewery/addbrewery", method = RequestMethod.POST)
    public boolean addBrewery(@RequestBody Brewer brewer) {
        return brewerDAO.addBrewery(brewer) > 0;
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.PUT)
    public boolean deleteBrewery(@PathVariable String id) {
        return brewerDAO.deleteBrewery(id);
    }

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


    //OLD and NOT used code -- DO NOT DELETE
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
}