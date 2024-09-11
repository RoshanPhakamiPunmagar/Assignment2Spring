/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.assignment2spring.controllers;

import org.example.assignment2spring.entity.Customer;
import org.example.assignment2spring.entity.Recommendation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import org.example.assignment2spring.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author caleb
 */
@RestController
@Data
@Service
@RequestMapping
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    //recommend movie route, pass it a customer object and it will send back a recomendation based off customers information
    @PostMapping("/getRecommendation")
    public Recommendation recommend(@RequestBody Customer cust) {
        return recommendationService.getRecommendation(cust);
    }

    //route that will display a web page with the recommended movie, pass a customer object.
    @GetMapping("/recommendMovie")
    public ModelAndView recommendMovie(@RequestBody Customer cust) {
        ModelAndView model = new ModelAndView();
        model.setViewName("recommended_movie.html");
        Recommendation recommendedMovie = recommendationService.getRecommendation(cust);
        model.addObject("movieTitle", recommendedMovie.getMovie().getTitle());
        model.addObject("movieUrl", recommendedMovie.getMovie().getUrl());
        return model;

    }

    @GetMapping("/recommendMovie/{id}")
    public ModelAndView recommendMovie(@PathVariable Long id) {

        Customer testCust = new Customer();
        testCust.setId(Long.parseLong(String.valueOf(1)));
        testCust.setName("Test");

        ModelAndView model = new ModelAndView();
        model.setViewName("recommended_movie.html");
        Recommendation recommendedMovie = recommendationService.getRecommendation(testCust);
        model.addObject("movieTitle", recommendedMovie.getMovie().getTitle());
        model.addObject("movieUrl", recommendedMovie.getMovie().getUrl());
        return model;

    }

    //lists all recommendations
    @GetMapping("/getRecommendations")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    //takes a customer id and will return a recomendation object
    @GetMapping("/getRecommendation/{id}")
    public Recommendation recommendId(@PathVariable Long id) {
        Customer testCust = new Customer();
        testCust.setId(Long.parseLong(String.valueOf(1)));
        testCust.setName("Test");
        return recommendationService.getRecommendation(testCust);
    }

}
