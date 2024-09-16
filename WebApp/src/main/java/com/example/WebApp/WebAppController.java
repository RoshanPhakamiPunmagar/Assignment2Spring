/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebApp;

import ch.qos.logback.core.model.Model;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author caleb
 */
@Controller
@Data
@RequestMapping
public class WebAppController {

    @Autowired
    private RecommendationClient recommendationClient;

    @Autowired
    private ScreamerClient screamerClient;

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index.html");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView registerCustomer() {
        ModelAndView model = new ModelAndView();
        model.setViewName("register.html");
        return model;
    }

    @GetMapping("/allMovies")
    public ModelAndView showAllMovies() {
        ModelAndView model = new ModelAndView();
        model.setViewName("movie_page.html");
        model.addObject("movies", screamerClient.getAllMovies());
        return model;
    }

    //This is not complete it needs to know what the logged in user is
    @GetMapping("/movieRecommendation")
    public ModelAndView recommendMovie() {
        ModelAndView model = new ModelAndView();
        model.setViewName("recommended_movie.html");
        Recommendation rec = recommendationClient.getRecommendation(1);
        model.addObject("movieTitle", rec.getMovieTitle());
        model.addObject("movieUrl", rec.getMovieUrl());
        return model;
    }

}
