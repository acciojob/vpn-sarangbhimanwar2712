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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String username ;
    private String password ;

    //Admin is parent wrt ServiceProvider --> admin can have multiple ServiceProviders
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList = new ArrayList<>() ;
}
