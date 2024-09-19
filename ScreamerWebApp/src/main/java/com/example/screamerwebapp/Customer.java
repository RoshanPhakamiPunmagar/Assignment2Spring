package com.example.screamerwebapp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
/**
 *
 * @author Anmol Saru Magar
 * File Name: Customer.java
 * Date :16/9/2024
 * Purpose :
 * Customer class that defines the Customer Entity
 * ******************************************************
 */
@Entity @Data @NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private long id;


    private String name;

    private String email;

    private String password;
    private String roll;

    @OneToOne (mappedBy = "customer")
    private WatchList watchList;

    @NonNull
    private boolean blocked;


}