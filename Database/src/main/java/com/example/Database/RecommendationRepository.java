/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author caleb
 */
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {}