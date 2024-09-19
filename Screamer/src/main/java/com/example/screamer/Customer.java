package com.example.screamer;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

/**
 *
 * @author Anmol Saru Magar
 * File Name: Movies.java
 * Date :16/9/2024
 * Purpose :
 * Customer class that defines the Customer Entity
 * ******************************************************
 */

@Entity @Data
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;
    private String roll;

    private boolean blocked;

    @OneToOne (mappedBy = "customer")
    private WatchList watchList;



}