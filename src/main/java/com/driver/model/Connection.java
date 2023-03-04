package com.driver.model;



import javax.persistence.*;

@Entity
@Table


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

    public Connection() {
    }

    public Connection(int id, ServiceProvider serviceProvider, User user) {
        this.id = id;
        this.serviceProvider = serviceProvider;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
