package com.techelevator.controller;
import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BrewerDAO;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import com.techelevator.services.BreweryDetails;
import com.techelevator.services.LocationConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private LocationConverter locationConverter;

    private BreweryDetails breweryDetails;

    private BeerDAO beerDAO;

    private BrewerDAO brewerDAO;

    private UserDao userDao;

    public BreweryController(BreweryDetails breweryDetails, BeerDAO beerDAO, LocationConverter locationConverter, BrewerDAO brewerDAO, UserDao userDao){
        this.breweryDetails = breweryDetails;
        this.beerDAO = beerDAO;
        this.locationConverter = locationConverter;
        this.brewerDAO = brewerDAO;
        this.userDao = userDao;
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
    public boolean addBeer(@PathVariable String id, @RequestBody BeerDetails beer, Principal principal) {

      //  String userName = principal.getName();
      //  int userId = userDao.findIdByUsername(userName);

        int jdbcBreweryId;

        if(id.length() > 14){
            jdbcBreweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if(jdbcBreweryId == 0){
                Brewer brewery = breweryDetails.getBreweryAndBeer(id); //API CALL



                int newBreweryId = brewerDAO.addBrewery(brewery, 1); //CREATES BREWERY IN POSTGRES
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

    @RequestMapping(path="/beer/{id}", method = RequestMethod.PUT)
    public boolean deleteBeer(@PathVariable String id) {
        int jdbcBeerId;
        try {
            if (id.length() > 14) {
                jdbcBeerId = beerDAO.apiBeerExistsInJdbc(id);
                if (jdbcBeerId == 0) {
                    BeerDetails beer = breweryDetails.getBeerById(id); //API CALL
                    //TODO when principal added replace breweryId with brewery associated with principal
                    int newBeerId = beerDAO.addBeer(beer, 1); //CREATES BREWERY IN POSTGRES
                    beerDAO.deleteBeer(String.valueOf(newBeerId));
                } else {
                    beerDAO.deleteBeer(String.valueOf(jdbcBeerId));
                }
            } else {
                beerDAO.deleteBeer(id);
            }
        }catch (ResourceAccessException e){

        }

        return beerDAO.deleteBeer(id);
    }

    @RequestMapping(path="/brewery/addbrewery", method = RequestMethod.POST)
    public boolean addBrewery(@RequestBody Brewer brewer) {
        return brewerDAO.addBrewery(brewer, 1) > 0;
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.PUT)
    public boolean deleteBrewery(@PathVariable String id) {
        int jdbcBreweryId;
        try {
            if (id.length() > 14) {
                jdbcBreweryId = brewerDAO.apiBreweryExistsInJdbc(id);
                if (jdbcBreweryId == 0) {
                    Brewer brewery = breweryDetails.getBreweryAndBeer(id); //API CALL
                    int newBreweryId = brewerDAO.addBrewery(brewery, 1); //CREATES BREWERY IN POSTGRES
                    brewerDAO.deleteBrewery(String.valueOf(newBreweryId));
                } else {
                    brewerDAO.deleteBrewery(String.valueOf(jdbcBreweryId));
                }
            } else {
                brewerDAO.deleteBrewery(id);
            }
        }catch (ResourceAccessException e){

        }

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