/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.RecommendationService;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author caleb
 */
@Controller
@Data
public class RecommendationController {
     private final RecommendationClient recommendationClient; //this will include the @FeignClient intefrace above, then you can call the retrieve function which is mapped to /dogs/{breed}. The feign client then connects to back end service retrieves data and passes to webapp
   
    
    @GetMapping("/ui/recommendation/{custID}")
    @ResponseBody // can return webpage in stead
    String _retrieve(@PathVariable Long custID) {
        
        Customer cust = recommendationClient.getCustomer(custID);
        Recommendation recommendation = new Recommendation();
        recommendation.addCustomer(cust);
        //get random movie and add to recommendation then save recommendation
        recommendation.addMovie(movie);
        return "<h1>" + recommendation + "</h1>";
    }
    
    
    
    Movies getRandomMovie()
    {
        recommendationClient.getMovies();
    }
    
}
