package com.techelevator.services;
import com.techelevator.model.BeerDetails;
import com.techelevator.model.BrewerDetails;
import com.techelevator.model.BreweryLocation;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.http.HttpResponse;


@Component
public class BreweryDetailsRest implements BreweryDetails{
    private static final String API_URL = "https://api.catalog.beer/";

    private RestTemplate restTemplate = new RestTemplate();

    public BreweryDetails[] getAllBreweries() {
        BreweryDetails[] allBreweries = null;
        ResponseEntity<BreweryDetails[]> response = restTemplate.exchange(API_URL+"brewer/", HttpMethod.GET, authEntity(), BreweryDetails[].class);
        allBreweries = response.getBody();
        return allBreweries;
    }

    public BrewerDetails getBrewery(String id){
        String brewerId = id;
        BrewerDetails brewery = null;
        ResponseEntity<BrewerDetails> response = restTemplate.exchange(API_URL+"brewer/"+id, HttpMethod.GET, authEntity(), BrewerDetails.class);
        brewery = response.getBody();
        return brewery;
    }
    //TODO Use with Jackson
    public BreweryLocation[] getFilterBreweriesByLocation(float latitude, float longitude,int search_radius) {
        ObjectMapper om = new ObjectMapper();
        BreweryLocation[] listOfBreweries = null;
        ResponseEntity<BreweryLocation[]> response = restTemplate.exchange(API_URL + "location/nearby?latitude=" + latitude + "&longitude=" + longitude + "&search_radius=" + search_radius, HttpMethod.GET, authEntity(), BreweryLocation[].class);
        return listOfBreweries;
    }



    public BreweryLocation[] getBreweryByLocation(float latitude, float longitude,int search_radius){
        BreweryLocation[] listOfBreweries = null;
        ResponseEntity<BreweryLocation[]> response = restTemplate.exchange(API_URL+"location/nearby?latitude="+latitude+"&longitude="+ longitude +"&search_radius="+search_radius, HttpMethod.GET, authEntity(), BreweryLocation[].class);
        listOfBreweries = response.getBody();
        return listOfBreweries;
    }

    public BeerDetails getBeerById(String id){
        BeerDetails beer = null;
        ResponseEntity<BeerDetails> response = restTemplate.exchange(API_URL+"beer/"+id, HttpMethod.GET, authEntity(), BeerDetails.class);
        beer = response.getBody();
        return beer;
    }

    private HttpEntity<BrewerDetails> authEntity() {
        String username = "d4b002c2-c531-437e-b2c1-12863de7507f";
        String password = "";
        MediaType json = MediaType.APPLICATION_JSON;
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.add("Accept", String.valueOf(json));
        return new HttpEntity<>(headers);
    }
}
