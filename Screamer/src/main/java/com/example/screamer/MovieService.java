package com.example.screamer;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {


    private final MovieClient movieClient;
    private final WatchListRepository watchListRepository;
    private final MoviesRepository movieRepository;
    private List<Movies> movies;
    private WatchList savedWatchList = new WatchList();

    public MovieService(MovieClient movieClient, WatchListRepository watchListRepository, MoviesRepository moviesRepository) {
        this.movieRepository = moviesRepository;
        movies = movieClient.getAllMovies();
        this.movieClient = movieClient;
        this.watchListRepository = watchListRepository;

    }


    public List<Movies> getAllMovies() {
        try {
            //List<Movies> movies = movieClient.getAllMovies();

            System.out.println(movies.get(0).getIsWatchList() + "X" + movies.get(1).getTitle());
            movieRepository.saveAll(movies);
            return movies;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
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
            WatchList watchLists = movieClient.getAllWatchList();
            watchListRepository.save(watchLists);
            return watchLists;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all movies: " + e.getMessage(), e);
        }
    }
/*
    public WatchList removeFromWatchList(Long id){
        List<Movies> movies =  getAllMovies();

     WatchList watchList = getAllWatchListMovies();

        List<Movies> moviesToAdd= watchList.getMovies();
        Movies movieToRemove = new Movies();
        for (Movies m : movies) {
            if (m.getId() == (id)) {
                m.setWatchList(false);
                movieToRemove = m;
                break;
            }
        }
        System.out.println(movieToRemove.getIsWatchList());
        movieRepository.save(movieToRemove);
        int x = 0;
        for(Movies w: watchList.getMovies()){
            System.out.println(w.getTitle());
            x++;
        }
            // Remove the movie from the list
        watchList.getMovies().remove(movieToRemove);

            WatchList updatedWatchList = watchListRepository.save(watchList);
            x = 0;
            for(Movies w: updatedWatchList.getMovies()){
                System.out.println(w.getTitle());
                x++;
            }
            // Save the updated watchlist
                movieClient.addMoveToWatchList(id, "Remove");


        return updatedWatchList;

    }*/
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


        movieRepository.save(movieToRemove);
        watchList.getMovies().remove(movieToRemove);
        WatchList updatedWatchList = watchListRepository.save(watchList);

        // Call Feign client to update remote watch list
        movieClient.addMoveToWatchList(id, "Remove");

        return updatedWatchList;

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
        //Saving to repository

        System.out.println(movieToAdd.getIsWatchList());
        //List<Movies> moviesToAdd= new ArrayList<>();

        //moviesToAdd.add(movieToAdd);
       // movieToAdd.setWatchList(movieToAdd.getIsWatchList());

        //WatchList watchList = new WatchList();
        savedWatchList.addMovie(movieToAdd);
        movieRepository.save(movieToAdd);
        movieClient.addMoveToWatchList(id, "Add");
        savedWatchList = watchListRepository.save(savedWatchList);

        return savedWatchList;
    }
}

