package com.example.screamerwebapp;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    private final RecommendationClient recommendationClient;
    private final MovieClient movieClient;
    private final CustomerClient customerClient;
    private List<Movies> movies;

    public MovieService(RecommendationClient recommendationClient, MovieClient movieClient , CustomerClient customerClient) {

        this.recommendationClient = recommendationClient;
        //   this.movieRepository = moviesRepository;
        this.movieClient = movieClient;

     //   this.watchListRepository = watchListRepository;
        this.customerClient = customerClient;
    }


    public List<Movies> getAllMovies() {
        try {
            return movieClient.getAllMovies();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public Movies getRecommendation(){
        return recommendationClient.getRecomendation().getBody();
    }

    public WatchList getAllWatchListMovies() {
        try {
            return movieClient.getAllWatchListMovies();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

public WatchList removeFromWatchList(Long id) {
        return  movieClient.addMoveToWatchList(id, "Remove");

}

    public WatchList addToWatchList(Long id) {
        return  movieClient.addMoveToWatchList(id, "Add");
    }
}

