
package org.example.assignment2spring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

interface RecommendationServiceInt {

 

    // Block a user by ID
    Recommendation getRecommendation(Customer cust);

  
   
}

@Service
public class RecommendationService implements RecommendationServiceInt 
{

    @Override
    public Recommendation getRecommendation(Customer cust) {
        // access customer databaase use information such as prefered genre then randomly select a moview from the list of movies with the matchig genre
        Recommendation recommendation = new Recommendation();
        recommendation.setCustomer(cust);
        Movies movie = new Movies();      
        movie.setTitle("Test movie");
        movie.setUrl("www.youtube.com");
        recommendation.setMovie(movie);
        
        return recommendation;
    }
    
}
