/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.assignment2spring;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bruce
 */
public interface RecomendationRepository extends JpaRepository<Recomendation, Long> {
    
}