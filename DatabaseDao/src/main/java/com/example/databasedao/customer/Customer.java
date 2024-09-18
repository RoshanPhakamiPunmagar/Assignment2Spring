
package com.example.databasedao.customer;

import com.example.databasedao.movies.WatchList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity @Data @NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String email;

    private String password;

    @NonNull
    private boolean blocked;

    @OneToOne (mappedBy = "customer")
    @JsonBackReference
    private WatchList watchList;




}

