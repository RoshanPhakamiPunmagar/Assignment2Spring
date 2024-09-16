/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author caleb
 */
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> mov = movieRepository.findAll();
        return ResponseEntity.ok(mov);
    }
}
