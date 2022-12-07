package com.techelevator.services;

import com.techelevator.model.ZipLongLat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LocationConverterRest implements LocationConverter{
    private static final String ZIP_START_API_URL = "http://api.openweathermap.org/geo/1.0/zip?zip=";
    private static final String ZIP_END_API_URL = ",US&appid=e423411c9f8c3238f6c34c3a703c7cec";

    private RestTemplate restTemplate = new RestTemplate();

    public ZipLongLat getCoordinates(int zip){
        ZipLongLat zipLongLat = null;
        ResponseEntity<ZipLongLat> latResponse = restTemplate.exchange(ZIP_START_API_URL+zip+ZIP_END_API_URL, HttpMethod.GET, zipAuthEntity(), ZipLongLat.class);
        zipLongLat = latResponse.getBody();
        return zipLongLat;
    }
    private HttpEntity<ZipLongLat> zipAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }
}
