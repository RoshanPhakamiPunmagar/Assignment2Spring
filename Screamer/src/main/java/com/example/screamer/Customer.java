package com.example.screamer;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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