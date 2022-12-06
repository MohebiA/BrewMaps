package com.techelevator.dao;

import com.techelevator.model.BeerDetails;

import java.util.List;

public interface BeerDAO {

    List<BeerDetails> getAllBeers();

    BeerDetails getBeerById(String id);

    void addBeer(BeerDetails beer);

    void deleteBeer(int beerId);

}
