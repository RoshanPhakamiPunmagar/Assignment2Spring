/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebApp;

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
    private WebAppClient webAppClient;

    @GetMapping("/movieRecommendation")
    public ModelAndView recommendMovie() {
        ModelAndView model = new ModelAndView();

        model.setViewName("recommended_movie.html");
        Recommendation rec = webAppClient.getRecommendation(1);
        model.addObject("movieTitle", rec.getTitle());
        model.addObject("movieUrl", rec.getMovieUrl());
        return model;

    }
}
