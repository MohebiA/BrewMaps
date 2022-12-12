package com.techelevator.controller;

import com.techelevator.dao.ExtraDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventController {

    private ExtraDAO extraDAO;

    public EventController(ExtraDAO extraDAO){
        this.extraDAO = extraDAO;
    }
}


