package com.techelevator.dao;

import com.techelevator.model.BeerDetails;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcBeerDao implements BeerDAO{

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BeerDetails> getAllBeers() {
        return null;
    }

    @Override
    public BeerDetails getBeerById(String id) {
        return null;
    }

    @Override
    public void addBeer(BeerDetails beer) {

    }

    @Override
    public void deleteBeer(int beerId) {

    }
}
