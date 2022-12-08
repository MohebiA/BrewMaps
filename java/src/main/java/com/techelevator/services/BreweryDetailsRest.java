package com.techelevator.services;
import com.techelevator.model.*;
import com.techelevator.model.APIBeerDatum.BeerDatum;
import com.techelevator.model.APIBeerDatum.BeerRoot;
import com.techelevator.model.APIDatum.Datum;
import com.techelevator.model.APIDatum.Location;
import com.techelevator.model.APIDatum.Root;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
public class BreweryDetailsRest implements BreweryDetails{
    private static final String API_URL = "https://api.catalog.beer/";
  //  private static final String ZIP_START_API_URL = "http://api.openweathermap.org/geo/1.0/zip?zip=";
  //  private static final String ZIP_END_API_URL = ",US&appid=e423411c9f8c3238f6c34c3a703c7cec";

    private RestTemplate restTemplate = new RestTemplate();

    private LocationConverterRest locationConverterRest;

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

    public BeerRoot getBreweryBeerList(String id) {
        BeerRoot beerList = null;
        ResponseEntity<BeerRoot> response = restTemplate.exchange(API_URL+"/brewer/"+id+"/beer", HttpMethod.GET, authEntity(), BeerRoot.class);
        beerList = response.getBody();
        return beerList;
    }
    //One that works - DO NOT DELETE!
    public List<BeerList> getBeerListByBrewery(String id) {
        BeerRoot listOfBeers = null;
        List<BeerList> beerList = new ArrayList<>();
        ResponseEntity<BeerRoot> response = restTemplate.exchange(API_URL+"/brewer/"+id+"/beer", HttpMethod.GET, authEntity(), BeerRoot.class);
        listOfBeers = response.getBody();

        for(BeerDatum beer : listOfBeers.getData()){
            BeerList beerToAdd = new BeerList();
            beerToAdd.setId(beer.getId());
            beerToAdd.setName(beer.getName());
            beerToAdd.setStyle(beer.getStyle());
            System.out.println(beerToAdd);
            beerList.add(beerToAdd);
        }
        return beerList;
    }

    public Brewer getBreweryAndBeer(String id) {
        BeerRoot listOfBeers = null;
        List<BeerList> beerList = new ArrayList<>();
        Brewer brewer = new Brewer();
        ResponseEntity<BeerRoot> response = restTemplate.exchange(API_URL+"/brewer/"+id+"/beer", HttpMethod.GET, authEntity(), BeerRoot.class);
        listOfBeers = response.getBody();

        for(BeerDatum beer : listOfBeers.getData()){
            BeerList beerToAdd = new BeerList();
            beerToAdd.setId(beer.getId());
            beerToAdd.setName(beer.getName());
            beerToAdd.setStyle(beer.getStyle());
            System.out.println(beerToAdd);
            beerList.add(beerToAdd);
        }

//        brewer.setApiBreweryId(listOfBeers.getBrewer().getId());
//        brewer.setName(listOfBeers.getBrewer().getName());
//        brewer.setUrl(listOfBeers.getBrewer().getUrl());
//        brewer.setDescription(listOfBeers.getBrewer().getDescription());
//        brewer.setFacebook_url(listOfBeers.getBrewer().getFacebook_url());
//        brewer.setInstagram_url(listOfBeers.getBrewer().getInstagram_url());
//        brewer.setTwitter_url(listOfBeers.getBrewer().getTwitter_url());
//        brewer.setBeerList(beerList);
        brewer = setBrewerDetails(listOfBeers,beerList);
        return brewer;
    }

    //TODO - added 12-06 - added zipcode method to use zip API to get lon/lat to filter by zip code
    public List<BrewerResults> getLongLatFromZip(double latitude, double longitude, int search_radius) {
      //  ZipLongLat zipLongLat = null;
      //  ResponseEntity<ZipLongLat> latResponse = restTemplate.exchange(ZIP_START_API_URL+zip+ZIP_END_API_URL, HttpMethod.GET, zipAuthEntity(), ZipLongLat.class);
      //  zipLongLat = latResponse.getBody();

      //  ZipLongLat zipLongLat = locationConverterRest.getCoordinates(zip);

        Root listOfBreweries = null;
        List<BrewerResults> nearbyBreweries = new ArrayList<>();
        ResponseEntity<Root> response = restTemplate.exchange(API_URL+"location/nearby?latitude="+latitude+"&longitude="+ longitude +"&search_radius="+search_radius, HttpMethod.GET, authEntity(), Root.class);
        listOfBreweries = response.getBody();

        for(Datum data : listOfBreweries.getData()){
            BrewerResults breweryToAdd = addBreweryToList(data);
            nearbyBreweries.add(breweryToAdd);
        }

        return nearbyBreweries;
    }

    public BeerDetails getBeerById(String apiId){
        BeerDetails beer = null;
        ResponseEntity<BeerDetails> response = restTemplate.exchange(API_URL+"beer/"+apiId, HttpMethod.GET, authEntity(), BeerDetails.class);
        beer = response.getBody();
        return beer;
    }

    //TODO - added 12-06 - added helper method section for ease of reference
//  HELPER METHODS
    private HttpEntity<BrewerDetails> authEntity() {
        String username = "d4b002c2-c531-437e-b2c1-12863de7507f";
        String password = "";
        MediaType json = MediaType.APPLICATION_JSON;
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        headers.add("Accept", String.valueOf(json));
        return new HttpEntity<>(headers);
    }

    private BrewerResults addBreweryToList(Datum data){
        BrewerResults brewerResults = new BrewerResults();
        brewerResults.setId(data.getBrewer().getId());
        brewerResults.setName(data.getBrewer().getName());
        brewerResults.setDistance((data.getDistance().getDistance()));
        brewerResults.setUrl(data.getBrewer().getUrl());
        brewerResults.setDescription(data.getBrewer().getDescription());
        return brewerResults;
    }

    private Brewer setBrewerDetails(BeerRoot root, List<BeerList> beerList ){
        Brewer brewer = new Brewer();
        brewer.setApiBreweryId(root.getBrewer().getId());
        brewer.setName(root.getBrewer().getName());
        brewer.setUrl(root.getBrewer().getUrl());
        brewer.setDescription(root.getBrewer().getDescription());
        brewer.setFacebook_url(root.getBrewer().getFacebook_url());
        brewer.setInstagram_url(root.getBrewer().getInstagram_url());
        brewer.setTwitter_url(root.getBrewer().getTwitter_url());
        brewer.setBeerList(beerList);

        return brewer;
    }
}
