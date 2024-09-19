package com.example.recommendation;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    private final RecomendationClient recommendationClient;

    public RecommendationService(RecomendationClient recommendationClient) {
        this.recommendationClient = recommendationClient;
    }

    public Movies getRecomendation(){
        return recommendationClient.getRecomendation().getBody();
    }
}
