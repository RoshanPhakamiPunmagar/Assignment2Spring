package com.example.databasedao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @NonNull
    private boolean blocked;

    @OneToOne (mappedBy = "customer")
    @JsonBackReference
    private WatchList watchList;




}
