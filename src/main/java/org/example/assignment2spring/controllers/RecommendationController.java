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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/recommendMovie")
    public Recommendation recommend(@RequestBody Customer cust) {
        return recommendationService.getRecommendation(cust);
    }

    @GetMapping("/recommendMovie")
    public ModelAndView recommend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("recommended_movie.html");
        return modelAndView;
    }

    @GetMapping("/recommendations")
    public List<Recommendation> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @GetMapping("/recommend/{id}")
    public Recommendation recommendId(@PathVariable Long id) {
        Customer testCust = new Customer();
        testCust.setId(Long.parseLong(String.valueOf(1)));
        testCust.setName("Test");
        return recommendationService.getRecommendation(testCust);
    }

}
