package com.driver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private CountryName countryName ;
    private String codes ;

    //1. Country is child wrt ServiceProvider
    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider ;

    //2. Country is child wrt to user
    @OneToOne
    @JoinColumn
    private User user ;

}
