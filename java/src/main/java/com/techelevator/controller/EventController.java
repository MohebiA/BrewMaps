package com.techelevator.controller;

import com.techelevator.dao.BrewerDAO;
import com.techelevator.dao.ExtraDAO;
import com.techelevator.model.Events;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    private ExtraDAO extraDAO;
    private BrewerDAO brewerDAO;

    public EventController(ExtraDAO extraDAO, BrewerDAO brewerDAO){
        this.extraDAO = extraDAO;
        this.brewerDAO = brewerDAO;
    }

    @RequestMapping (path = "/brewery/{id}/events", method = RequestMethod.GET)
    public List<Events> getAllEventsByBrewery(@PathVariable String id){
        List<Events> eventList = new ArrayList<>();
        int breweryId;

        if(id.length() < 14){
            breweryId = Integer.parseInt(id);
            eventList = extraDAO.getEventsbyBrewery(breweryId);
        }
        else {
            breweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if (breweryId != 0){
                eventList = extraDAO.getEventsbyBrewery(breweryId);
            }
        }
        return eventList;
    }

    @RequestMapping (path = "/brewery/{id}/addevents", method = RequestMethod.POST)
    public boolean addEvent(@RequestBody Events events, @PathVariable String id){
        Events event = events;
        int eventId = 0;
        int breweryId;

        if(id.length() < 14){
            breweryId = Integer.parseInt(id);
            event.setBreweryId(breweryId);
            eventId = extraDAO.addEvent(event);
        }
        else {
            breweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if (breweryId != 0){
                event.setBreweryId(breweryId);
                eventId = extraDAO.addEvent(events);
            }
        }
        return (eventId > 0);
    }
}


