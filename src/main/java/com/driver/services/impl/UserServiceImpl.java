package com.driver.services.impl;

import com.driver.model.Country;
import com.driver.model.ServiceProvider;
import com.driver.model.*;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.repository.UserRepository;
import com.driver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository3;
    @Autowired
    ServiceProviderRepository serviceProviderRepository3;
    @Autowired
    CountryRepository countryRepository3;

    @Override
    public User register(String username, String password, String countryName) throws Exception {
        User user = new User();
        Country country = countryRepository3.findByName(countryName) ;

        String originalIp = country.getCodes() + String.valueOf(user.getId());

        //Setting attributes
        user.setUsername(username);
        user.setPassword(password);
        user.setOriginalIP(originalIp);
        user.setMaskedIP(null);
        user.setConnected(false);

        //Setting foreign attributes
        user.setCountry(country);
        user = userRepository3.save(user) ;

        return user ;
    }

    @Override
    public User subscribe(Integer userId, Integer serviceProviderId) {

        User user = userRepository3.findById(userId).get() ;
        ServiceProvider serviceProvider = serviceProviderRepository3.findById(serviceProviderId).get() ;

        List<ServiceProvider> list = user.getServiceProviderList() ;
        list.add(serviceProvider) ;

        user.setServiceProviderList(list);
        user = userRepository3.save(user) ;
        return user ;
    }
}
