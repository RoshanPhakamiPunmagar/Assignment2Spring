package com.example.screamer;



import jakarta.persistence.*;
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