/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Database;

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
    @OneToOne
    private Movie movie;
    @ManyToOne
    private Customer customer;

    public void addMovie(Movie movie) {
        if (!this.movie.equals(movie)) {
            this.movie = movie;
        }
    }

    public void addCustomer(Customer cust) {
        if (!this.customer.equals(cust)) {
            this.customer = cust;
        }
    }
}
