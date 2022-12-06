package com.techelevator.controller;
import com.techelevator.model.BeerDetails;
import com.techelevator.model.BrewerDetails;
import com.techelevator.model.BreweryLocation;
import com.techelevator.services.BreweryDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDetails breweryDetails;

    public BreweryController(BreweryDetails breweryDetails){
        this.breweryDetails = breweryDetails;
    }

    @RequestMapping(path="/breweries", method = RequestMethod.GET)
    public BreweryDetails[] getAllBreweries(){
        return breweryDetails.getAllBreweries();
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
    public BrewerDetails getOneBrewery(@PathVariable String id){
        return breweryDetails.getBrewery(id);
    }

    @RequestMapping(path="/location/nearby", method = RequestMethod.GET)
    public BreweryLocation[] getBreweryByLocation(@RequestParam float latitude, @RequestParam float longitude, @RequestParam int search_radius){
//        return breweryDetails.getFilterBreweriesByLocation(latitude, longitude,search_radius);
        return null;
    }

    @RequestMapping(path="/beer/{id}", method = RequestMethod.GET)
    public BeerDetails getBeerById(@PathVariable String id){
        return breweryDetails.getBeerById(id);
    }
}