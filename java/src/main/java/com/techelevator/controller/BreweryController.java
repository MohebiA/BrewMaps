package com.techelevator.controller;
import com.techelevator.dao.BeerDAO;
import com.techelevator.dao.BrewerDAO;
import com.techelevator.dao.ReviewsDAO;
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

    private ReviewsDAO reviewsDAO;

    public BreweryController(BreweryDetails breweryDetails, BeerDAO beerDAO, LocationConverter locationConverter, BrewerDAO brewerDAO, UserDao userDao, ReviewsDAO reviewsDAO){
        this.breweryDetails = breweryDetails;
        this.beerDAO = beerDAO;
        this.locationConverter = locationConverter;
        this.brewerDAO = brewerDAO;
        this.userDao = userDao;
        this.reviewsDAO = reviewsDAO;
    }

    @RequestMapping(path="/breweries", method = RequestMethod.GET)
    public BreweryDetails[] getAllBreweries(){
        return breweryDetails.getAllBreweries();
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
    public Brewer getBreweryBeerList(@PathVariable String id){
        Brewer result;
        List<BeerList> beerList;
        //String breweryApiId = (breweryDetails.locationIDtoBreweryId(id).length() > 14) ? breweryDetails.locationIDtoBreweryId(id) : id ;
        String breweryApiId = id;

        if(id.length() < 14){
            int breweryId = Integer.parseInt(id);
            String returnedId = brewerDAO.getApiBreweryIdFromDatabase(breweryId);
            if(returnedId != null){
                breweryApiId = returnedId;
            }
        }
        if(breweryApiId.length() > 14){
            result = breweryDetails.getBreweryAndBeer(breweryApiId);
            beerList = beerDAO.checkForDeletedBeers(result);
            result.setBeerList(beerList);
            if(brewerDAO.apiBreweryExistsInJdbc(breweryApiId) > 0){
                List<BeerList> jdbcBeerList = (beerDAO.getBreweryBeerByBreweryId(brewerDAO.apiBreweryExistsInJdbc(breweryApiId)));
                for (BeerList beer : jdbcBeerList){
                    beerList.add(beer);
                }
            }
        }
        else{
            int intId = Integer.parseInt(id);
            result =  brewerDAO.getBrewerByBreweryId(intId);
        }

        return result;
    }

    //TODO this uses locationID instead of api_brewery_id
//    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
//    public Brewer getBreweryBeerList(@PathVariable String id){
//        Brewer result;
//        List<BeerList> beerList;
//        String breweryApiId = id;
//        if (breweryApiId.length() > 14) {
//            breweryApiId = (breweryDetails.locationIDtoBreweryId(id).length() > 14) ? breweryDetails.locationIDtoBreweryId(id) : id;
//        }
//
//        if(breweryApiId.length() < 14){
//            int breweryId = Integer.parseInt(id);
//            String returnedId = brewerDAO.getApiBreweryIdFromDatabase(breweryId);
//            if(returnedId != null){
//                breweryApiId = returnedId;
//            }
//        }
//        if(breweryApiId.length() > 14){
//            result = breweryDetails.getBreweryAndBeer(breweryApiId);
//            beerList = beerDAO.checkForDeletedBeers(result);
//            result.setBeerList(beerList);
//        }
//        else{
//            int intId = Integer.parseInt(breweryApiId);
//            result =  brewerDAO.getBrewerByBreweryId(intId);
//        }
//
//        return result;
//    }

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
            result = beerDAO.getBeerByBeerId(intId);
        }

        result.setReviews(reviewsDAO.getAllReviewsForBeer(id));

        return result;
    }

    //TODO id equals brewery id
    @RequestMapping(path="/brewery/{id}/addbeer", method = RequestMethod.POST)
    public boolean addBeer(@PathVariable String id, @RequestBody BeerDetails beer, Principal principal) {

    //  String userName = principal.getName();
    //  int userId = userDao.findIdByUsername(userName);
    // String breweryApiId = (breweryDetails.locationIDtoBreweryId(id).length() > 14) ? breweryDetails.locationIDtoBreweryId(id) : id ;

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
        int zip = Integer.parseInt(brewer.getZip());
        ZipLongLat zipLongLat = locationConverter.getCoordinates(zip);
        brewer.setLatitude(zipLongLat.getLat());
        brewer.setLongitude(zipLongLat.getLon());

        return brewerDAO.addBrewery(brewer, 1) > 0; //Userid will come from Principal
    }

    @RequestMapping(path="/brewery/{id}", method = RequestMethod.PUT)
    public boolean deleteBrewery(@PathVariable String id) {
        //String breweryApiId = (breweryDetails.locationIDtoBreweryId(id).length() > 14) ? breweryDetails.locationIDtoBreweryId(id) : id ;
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

    @RequestMapping(path="/beer/{id}/reviews", method = RequestMethod.POST)
    public boolean addReview(@PathVariable String id, @RequestBody Reviews reviews, Principal principal){
//        int userId = userDao.findIdByUsername(principal.getName());
        int userId = 1;
        int jdbcBeerId = 0;
        int jdbcBreweryId = 0;
        int newReview = 0;
        String apiBreweryId;

        try {
            if (id.length() > 14) { //BEER ID > 14
                jdbcBeerId = beerDAO.apiBeerExistsInJdbc(id); //CHECK IF JDBC has beer
                if (jdbcBeerId == 0) { //If beer does not exist -- trigger this block
                    BeerDetails beer = breweryDetails.getBeerById(id); //GET BEER FROM API
                    apiBreweryId = beer.getBrewer().getApiBreweryId();
                    jdbcBreweryId = brewerDAO.apiBreweryExistsInJdbc(apiBreweryId); //CHECK IF JDBC has brewery
                    if (jdbcBreweryId == 0) { //If brewery does not exist -- trigger this block
                        Brewer brewery = breweryDetails.getBreweryAndBeer(apiBreweryId); //API CALL TO GET BREWERY
                        jdbcBreweryId = brewerDAO.addBrewery(brewery, userId); //CREATES BREWERY IN POSTGRES
                    }
                    jdbcBeerId = beerDAO.addBeer(beer, jdbcBreweryId); //CREATES BEER IN POSTGRES //TODO when principal added replace breweryId with brewery associated with principal
                }else {
                    jdbcBreweryId = beerDAO.getBeerByBeerId(jdbcBeerId).getBreweryId();
                }
            } else {
                jdbcBeerId = Integer.parseInt(id);
                jdbcBreweryId = beerDAO.getBeerByBeerId(jdbcBeerId).getBreweryId();
            }
            newReview = reviewsDAO.addReview(reviews, jdbcBeerId, userId, jdbcBreweryId);

            }
        catch (Exception e){}

        return (newReview > 0);
    }

    //This was a test idea created by Sean, no use for the capstone
    @RequestMapping(path="/location/{id}", method = RequestMethod.GET)
    public String getBreweryIdByLocationId(@PathVariable String id){
        return breweryDetails.locationIDtoBreweryId(id);
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
//    @RequestMapping(path="/beer/{id}/reviews", method = RequestMethod.GET)
//    public List<Reviews> getReviews(@PathVariable String id){
//        return reviewsDAO.getAllReviewsForBeer(id);
//    }

    //    TODO - OLD DOESNT WORK WITH API AND JDBC Connection
//    @RequestMapping(path="/brewery/{id}", method = RequestMethod.GET)
//    public Brewer getBreweryBeerList(@PathVariable String id){
//        Brewer result;
//        String breweryApiId;
//
//        if(id.length() > 14){
//            result = brewerDAO.getBrewerByApiId(id);
//            if(result == null){
//                result = breweryDetails.getBreweryAndBeer(id);
//            }
//        }
//        else{
//            int intId = Integer.parseInt(id);
//            result =  brewerDAO.getBrewerByBreweryId(intId);
//        }
//        return result;
//    }
}