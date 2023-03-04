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

public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;

    //1.  ServiceProvider is child wrt to Admin
    @ManyToOne
    @JoinColumn
    private Admin admin ;

    //2.  ServiceProvider is parent wrt Connection --> serviceProvider my have multiple connections
    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>() ;

    //3.  ServiceProvider is also parent wrt Country ---> One serviceProvider can provide service to multiple countries
    @OneToMany(mappedBy = "serviceProvider" ,cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>() ;

    //4. ServiceProvider is having many to many relationship with user
    @ManyToMany(mappedBy = "serviceProviderList",cascade = CascadeType.ALL)
    private List<User> userList = new ArrayList<>() ;
}
