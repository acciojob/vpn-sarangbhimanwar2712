package com.driver.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table

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

    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, Admin admin, List<Connection> connectionList, List<Country> countryList, List<User> userList) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.connectionList = connectionList;
        this.countryList = countryList;
        this.userList = userList;
    }

    public ServiceProvider(String name, Admin admin) {
        this.name = name;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
