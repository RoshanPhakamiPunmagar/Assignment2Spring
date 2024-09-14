package com.example.RecommendationService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

interface RecommendationServiceInt {

    Recommendation getRecommendation(Customer cust);

    List<Recommendation> getAllRecommendations();

}

@Service
public class RecommendationService implements RecommendationServiceInt {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    Random random = new Random();

    @Override
    public Recommendation getRecommendation(Customer cust) {
        // access customer databaase use information such as prefered genre then randomly select a moview from the list of movies with the matchig genre

        List<Movies> movies = moviesRepository.findAll();

        Recommendation recommendation = new Recommendation();
        recommendation.setCustomer(cust);
        Movies movie = movies.get(random.nextInt(movies.size()) + 1);
        recommendation.setMovie(movie);

        return recommendation;
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

}
