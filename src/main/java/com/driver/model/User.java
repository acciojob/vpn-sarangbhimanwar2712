package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username ;
    private String password ;
    private String originalIP ;
    private String maskedIP ;
    private boolean connected ;

    //1. User is having many to many relationship with  ServiceProvider
    @ManyToMany
    private List<ServiceProvider> serviceProviderList = new ArrayList<>() ;

    //2. User is parent wrt Connection
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>() ;

    //3. User  belongs to only one country--> one to one relation
    @OneToOne
    private Country country ;


}
