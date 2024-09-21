package com.example.databasedao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Author: ??
 * Contributor Caleb Davidson
 * File Name: AdminMoviesController.java
 * Date: 16/9/2024
 * Purpose:
 * Main data class for customer entity
 * ******************************************************
 */

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;

    private String roll;
    private String genre;

    @OneToOne(mappedBy = "customer")
    @JsonManagedReference(value = "customer-class")
    private WatchList watchList;
    @NonNull
    private boolean blocked;

}
