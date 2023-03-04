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

public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    //1. Connection is  child wrt ServiceProvider
    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider ;

    //2. Connection is child wrt User
    @ManyToOne
    @JoinColumn
    private User user ;
}
