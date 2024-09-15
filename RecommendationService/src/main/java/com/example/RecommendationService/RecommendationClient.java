/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RecommendationService;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author caleb
 */
@FeignClient(name = "Database")
interface RecommendationClient {

    @GetMapping("/recommendations/{custId}")
    Recommendation getRecommendation(@PathVariable long custId);
    @GetMapping("/customers/{custId}")
    Customer getCustomer(@PathVariable long custId);
    @GetMapping("/")
    List<Movie> getMovies();

}
