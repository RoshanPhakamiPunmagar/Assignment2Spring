/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author caleb
 */
@Entity
@Data
@NoArgsConstructor

public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;
    
    private String movieTitle;

    private String movieUrl;

    private long customerId;
}
