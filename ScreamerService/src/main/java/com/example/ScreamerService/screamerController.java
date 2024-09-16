/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ScreamerService;

import java.util.List;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author caleb
 */
@Controller
@Data
public class screamerController {

    private final ScreamerClient screamerClient;

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(screamerClient.getMovies());
    }

    @GetMapping("/getWatchList/{custID}")
    public ResponseEntity<List<WatchList>> getWatchList(@PathVariable long custID) {
        return ResponseEntity.ok(screamerClient.getWatchList(custID));
    }

}
