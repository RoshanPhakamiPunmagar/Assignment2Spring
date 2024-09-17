package com.example.screamerwebapp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity @Data
public class Customer {
    @Id
    @GeneratedValue
    private long id;


    private String name;

    private String email;

    private String password;

    @OneToOne (mappedBy = "customer")
    private WatchList watchList;



}