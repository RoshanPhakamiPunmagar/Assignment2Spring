/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.assignment2spring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@NoArgsConstructor

public class Recomendation {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Movies movie;
    @ManyToOne
    private Customer customer;
    
     public void addMovie(Movies movie) {
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
