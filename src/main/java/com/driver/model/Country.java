package com.driver.model;


import javax.persistence.*;

@Entity
@Table


public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "country_name", unique = true)
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

    public Country() {
    }

    public Country(CountryName countryName, ServiceProvider serviceProvider) {
        this.countryName = countryName;
        this.serviceProvider = serviceProvider;
    }

    public Country(int id, CountryName countryName, String codes, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.countryName = countryName;
        this.codes = codes;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
