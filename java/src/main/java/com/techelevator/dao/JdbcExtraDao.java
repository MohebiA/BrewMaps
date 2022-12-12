package com.techelevator.dao;

import com.techelevator.model.Events;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcExtraDao implements ExtraDAO{

    private JdbcTemplate jdbcTemplate;

    private BrewerDAO brewerDAO;
    private UserDao userDao;

    public JdbcExtraDao(JdbcTemplate jdbcTemplate, BrewerDAO brewerDAO, UserDao userDao){
        this.jdbcTemplate = jdbcTemplate;
        this.brewerDAO = brewerDAO;
        this.userDao = userDao;
    }

    @Override
    public List<Events> getEventsbyBrewery(int id) {
        List<Events> breweryEvents = new ArrayList<>();
        String sql = "select * from events where brewery_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()){
            breweryEvents.add(mapRowToEventResults(results));

        }
        return breweryEvents;
    }

    @Override
    public boolean addEvent(Events events) {


        return false;
    }

    @Override
    public Events getEventbyId(int id) {
        Events event = null;

        String sql = "select * from events where event_id = ?;";


        return null;
    }

    @Override
    public boolean deleteEvent(int id) {
        return false;
    }

    @Override
    public boolean updateEvent(int id, Events events) {
        return false;
    }

    private Events mapRowToEventResults(SqlRowSet results){
        Events events = new Events();

        events.setDate(results.getDate("event_date"));
        events.setTime(results.getTime("event_time"));
        events.setDescription(results.getString("description"));
        events.setEventId(results.getInt("event_id"));
        events.setBreweryId(results.getInt("brewery_id"));

        return events;
    }


}
