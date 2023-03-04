package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ConnectionRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {
    @Autowired
    UserRepository userRepository2;
    @Autowired
    ServiceProviderRepository serviceProviderRepository2;
    @Autowired
    ConnectionRepository connectionRepository2;

    @Override
    public User connect(int userId, String countryName) throws Exception{

        Connection connection = new Connection() ;


        User user = userRepository2.findById(userId).get() ;
        boolean check = user.isConnected() ;

        //If user is already connected then we can't make new connection because it is already having connection established
        if(check){
            throw new  Exception("Already connected") ;
        }

        String name = String.valueOf(user.getCountry().getCountryName());

        //If original country of user and the country to which user want to establish connection then no need to  do anything
        if(name==countryName){
            user.setConnected(true);
            connection.setUser(user);
            connectionRepository2.save(connection) ;
            return user ;
        }

        List<ServiceProvider> serviceProviders = user.getServiceProviderList() ;


        return user ;
    }
    @Override
    public User disconnect(int userId) throws Exception {
        User user = userRepository2.findById(userId).get() ;
        boolean check = user.isConnected() ;
        if(!check){
            throw new Exception("Already disconnected") ;
        }
        user.setConnected(false);
        user.setMaskedIP(null);
        user = userRepository2.save(user) ;

        return user ;
    }
    @Override
    public User communicate(int senderId, int receiverId) throws Exception {

        return null ;
    }
}
