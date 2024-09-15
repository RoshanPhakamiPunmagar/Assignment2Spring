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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @GetMapping("/getRecommendation/{recID}")
    public ResponseEntity<Recommendation> getRecommendation(@PathVariable long recID) {
        Recommendation rec = recommendationRepository.findById(recID).get();
        return ResponseEntity.ok(rec);
    }

    @GetMapping("/getRecommendations/")
    public ResponseEntity<List<Recommendation>> getRecommendations() {
        List<Recommendation> rec = recommendationRepository.findAll();
        return ResponseEntity.ok(rec);
    }

    @DeleteMapping("/deleteRecommendation/{recID}")
    public void deleteRecommendation(@PathVariable long recID) {
        recommendationRepository.deleteById(recID);
    }

    @PutMapping("/updateRecommendation/{recID}")
    public void updateRecommendation(@PathVariable long recID, @RequestBody Recommendation rec) {

        Recommendation oldRec = recommendationRepository.findById(recID).get();
        oldRec = rec;
        recommendationRepository.save(oldRec);

    }

    @PostMapping("/addRecommendation")
    public void addRecommendation(@RequestBody Recommendation rec) {
        recommendationRepository.save(rec);
    }

}
