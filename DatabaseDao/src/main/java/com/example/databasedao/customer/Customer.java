<<<<<<<< HEAD:DatabaseDao/src/main/java/com/example/databasedao/customer/Customer.java

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

========
package com.example.databasedao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
>>>>>>>> f1a1b85d452a349d67ec6d6127249a55b23179a4:DatabaseDao/src/main/java/com/example/databasedao/Customer.java
