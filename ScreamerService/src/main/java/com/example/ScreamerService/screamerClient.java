/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ScreamerService;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author caleb
 */
@FeignClient(name = "Database", url = "http://localhost:8000")
interface ScreamerClient {

    @GetMapping("/getMovies")
    List<Movie> getMovies();
    
    @GetMapping("/getWatchList")
    List<WatchList> getWatchList();

}
