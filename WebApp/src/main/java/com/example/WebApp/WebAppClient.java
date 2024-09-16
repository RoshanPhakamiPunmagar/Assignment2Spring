/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebApp;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author caleb
 */
@FeignClient(name = "recommendationService", url = "http://localhost:8333")
interface RecommendationClient {

    @GetMapping("/recommendation/{custID}")
    Recommendation getRecommendation(@PathVariable long custID);

}

@FeignClient(name = "screanerService", url = "http://localhost:8888")
interface ScreamerClient {

    @GetMapping("/getMovies")
    List<Movie> getAllMovies();
    
    @GetMapping("/getWatchList/{custID}")
    List<WatchList> getWatchList(@PathVariable long custID);
}
