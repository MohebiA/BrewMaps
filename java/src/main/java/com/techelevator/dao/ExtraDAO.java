package com.techelevator.dao;

import com.techelevator.model.Events;

import java.util.List;

public interface ExtraDAO {

    List<Events> getEventsbyBrewery(int id);

    int addEvent(Events events);

    Events getEventbyId(int id);

    boolean deleteEvent(int id);

    boolean updateEvent(int id, Events events);


}
