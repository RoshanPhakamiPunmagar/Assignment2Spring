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
    private WatchList savedWatchList = new WatchList();

    public MovieService(RecommendationClient recommendationClient, MovieClient movieClient , CustomerClient customerClient) {
        this.recommendationClient = recommendationClient;
        //   this.movieRepository = moviesRepository;
        movies = movieClient.getAllMovies();
        this.movieClient = movieClient;
     //   this.watchListRepository = watchListRepository;
        this.customerClient = customerClient;
    }


    public List<Movies> getAllMovies() {
        try {
            //List<Movies> movies = movieClient.getAllMovies();

            //System.out.println(movies.get(0).getIsWatchList() + "X" + movies.get(1).getTitle());
          //  movieRepository.saveAll(movies);
          movies = movieClient.getAllMovies();
            return movies;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

    public Movies getRecommendation(){
        return recommendationClient.getRecomendation().getBody();
    }
    @Transactional
    public Movies updateMovie(Long id, Movies x) {
        System.out.println("124124");
        System.out.println(id);
        List<Movies> movies = getAllMovies();
        System.out.println(id);
        Movies existingMovie = new Movies();
        System.out.println(id);
        for (Movies m : movies) {
            if (m.getId() == id) {
                existingMovie = m;
                break;
            }
        }

        System.out.println(existingMovie.getId());
        // Update the fields as needed
        existingMovie.setWatchList(!x.getIsWatchList());
        existingMovie.setTitle("qweqweqwe");

        movieClient.updateMovieById(id, existingMovie);
        // Save the updated movie
        return existingMovie;
    }
    public WatchList getAllWatchListMovies() {
        try {
            System.out.println(getAllMovies().get(0).getIsWatchList());
            WatchList watchLists = movieClient.getAllWatchListMovies();
          //  watchListRepository.save(watchLists);
            return watchLists;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }

public WatchList removeFromWatchList(Long id) {
    List<Movies> movies = getAllMovies();
    WatchList watchList = getAllWatchListMovies();

    Movies movieToRemove = null;
    for (Movies m : movies) {
        if (m.getId()==(id)) {
            m.setWatchList(false);
            movieToRemove = m;
            break;
        }
    }


       // movieRepository.save(movieToRemove);
        watchList.getMovies().remove(movieToRemove);
    //    WatchList updatedWatchList = watchListRepository.save(watchList);

        // Call Feign client to update remote watch list
        movieClient.addMoveToWatchList(id, "Remove");

        return watchList;

}

    public WatchList addToWatchList(Long id) {
        List<Movies> movies =  getAllMovies();

   Movies movieToAdd = new Movies();
        for (Movies m : movies) {
            if (m.getId() == id) {
                System.out.println(m.getIsWatchList());
                m.setWatchList(true);
                movieToAdd = m;
            }
        }
        //Adding Customer
        Long x = 1L;


        savedWatchList.addMovie(movieToAdd);

        savedWatchList.setCustomer(customerClient.retrieveById(x).getBody());
        movieClient.addMoveToWatchList(id, "Add");


        return savedWatchList;
    }
}

