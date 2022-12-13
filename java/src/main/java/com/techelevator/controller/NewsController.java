package com.techelevator.controller;


import com.techelevator.dao.BrewerDAO;
import com.techelevator.dao.ExtraDAO;
import com.techelevator.model.News;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class NewsController {

    private ExtraDAO extraDAO;
    private BrewerDAO brewerDAO;

    public NewsController(ExtraDAO extraDAO, BrewerDAO brewerDAO) {
        this.extraDAO = extraDAO;
        this.brewerDAO = brewerDAO;
    }

    @RequestMapping(path = "/brewery/{id}/news", method = RequestMethod.GET)
    public List<News> getAllNewsFromBrewery(@PathVariable String id){
        List<News> newsList = new ArrayList<>();
        int breweryId;

        if(id.length() < 14){
            breweryId = Integer.parseInt(id);
            newsList = extraDAO.listOfNews(breweryId);
        }
        else {
            breweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if (breweryId != 0){
                newsList = extraDAO.listOfNews(breweryId);
            }
        }
        return newsList;
    }

    @RequestMapping (path = "/brewery/{id}/addnews", method = RequestMethod.POST)
    public boolean addEvent(@RequestBody News news, @PathVariable String id){
        News newNews = news;
        int newsId = 0;
        int breweryId;

        if(id.length() < 14){
            breweryId = Integer.parseInt(id);
            newNews.setBreweryId(breweryId);
            newsId = extraDAO.createNews(newNews);
        }
        else {
            breweryId = brewerDAO.apiBreweryExistsInJdbc(id);
            if (breweryId != 0){
                newNews.setBreweryId(breweryId);
                newsId = extraDAO.createNews(newNews);
            }
        }
        return (newsId > 0);
    }


}
