/*
package org.example.assignment2spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Screamer", url = "http://localhost:8001/Screamer") // Change this to the actual movie service URL
public interface MovieClient {

 @GetMapping("/movies/{id}")
 ResponseEntity<Movies> retrieve(@PathVariable Long id);

 @GetMapping("/movies")
 ResponseEntity<List<Movies>> retrieveAll();

 @PostMapping("/movies")
 ResponseEntity<Movies> create(@RequestBody Movies movies);

 @PutMapping("/movies/{id}")
 ResponseEntity<Movies> update(@PathVariable("id") Long id, @RequestBody Movies movies);

 @PostMapping("/movies/{id}/removeOrAddToWatchList")
 void removeOrAddToWatchList(@PathVariable Long id);

 @GetMapping("/watchlist")
 List<WatchList> showWatchList();
}
*/