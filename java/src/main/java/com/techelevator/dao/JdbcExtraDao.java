package com.techelevator.dao;

import com.techelevator.model.Events;
import com.techelevator.model.News;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

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
    public int addEvent(Events events) {
        String sql = "INSERT INTO events (event_date, event_time, brewery_id, description) VALUES (?, ?, ?, ?) RETURNING event_id;";

        try {
            Integer newEventId = jdbcTemplate.queryForObject(sql, Integer.class, events.getDate(), events.getTime(), events.getBreweryId(), events.getDescription());
            return (newEventId);
        } catch (ResourceAccessException rae) {
            return 0;
        }
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

    @Override
    public int createNews(News news) {
        String sql = "INSERT INTO news (description, brewery_id) VALUES (?, ?) RETURNING news_id;";

        try {
            Integer newEventId = jdbcTemplate.queryForObject(sql, Integer.class, news.getDescription(), news.getBreweryId());
            return (newEventId);
        } catch (ResourceAccessException rae) {
            return 0;
        }
    }

    @Override
    public List<News> listOfNews(int breweryId) {
        List<News> listOfNews = new ArrayList<>();
        String sql = "SELECT * FROM news WHERE brewery_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()){
            listOfNews.add(mapRowToNewsResults(results));
        }
        return listOfNews;
    }

    private Events mapRowToEventResults(SqlRowSet results){
        Events events = new Events();

        events.setDate(results.getDate("event_date").toLocalDate());
        events.setTime(results.getTime("event_time").toLocalTime());
        events.setDescription(results.getString("description"));
        events.setEventId(results.getInt("event_id"));
        events.setBreweryId(results.getInt("brewery_id"));

        return events;
    }

    private News mapRowToNewsResults(SqlRowSet results){
        News news = new News();

        news.setNewsId(results.getInt("news_id"));
        news.setDescription(results.getString("description"));
        news.setBreweryId(results.getInt("brewery_id"));

        return news;
    }


}
