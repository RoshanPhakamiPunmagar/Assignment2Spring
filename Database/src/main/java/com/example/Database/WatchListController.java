/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author caleb
 */
@RestController
@Data
@Service
@RequestMapping
public class WatchListController {

    private final WatchListRepository watchListRepository;

    @GetMapping("/getWatchList/{custID}")
    public ResponseEntity<WatchList> getWatchList(@PathVariable long custID) {
        WatchList watchList = watchListRepository.findBycustID(custID);

        return ResponseEntity.ok(watchList);
    }

    @GetMapping("/getWatchList")
    public ResponseEntity<WatchList> getWatchList() {
        WatchList watchList = watchListRepository.findById((long) 1).get();
        return ResponseEntity.ok(watchList);
    }
}
