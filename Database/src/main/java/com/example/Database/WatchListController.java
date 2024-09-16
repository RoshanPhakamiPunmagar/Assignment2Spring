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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author caleb
 */
@RestController
@Data
@Service
@RequestMapping
public class WatchListController {

    @Autowired
    private WatchListRepository watchListRepository;

    @GetMapping("/getWatchList/{custID}")
    public ResponseEntity<List<WatchList>> getWatchList(@PathVariable long custID) {
        List<WatchList> watchList = watchListRepository.findBycustID(custID);

        return ResponseEntity.ok(watchList);
    }
}