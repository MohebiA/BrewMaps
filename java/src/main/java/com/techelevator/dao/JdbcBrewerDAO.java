package com.techelevator.dao;

import com.techelevator.model.BrewerDetails;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcBrewerDAO implements BrewerDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcBrewerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BrewerDetails getBrewerById(String id) {
        return null;
    }

    @Override
    public List<BrewerDetails> getAllBrewers() {
        return null;
    }

    @Override
    public void addBrewery(BrewerDetails breweryId) {

    }

    @Override
    public void deleteBrewery(BrewerDetails breweryId) {

    }
}
