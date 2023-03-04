package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin = new Admin() ;
        admin.setPassword(username);
        admin.setPassword(password);
        adminRepository1.save(admin) ;

        return admin ;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        //get admin
        Admin admin = adminRepository1.findById(adminId).get() ;

        //get service provider by name
        ServiceProvider serviceProvider = serviceProviderRepository1.findByName(providerName) ;

        //get list of service provider from admin
        List<ServiceProvider> serviceProviderList = admin.getServiceProviderList() ;

        //add the serviceProvider to current list
        serviceProviderList.add(serviceProvider) ;

        //set the list and save in the repo then return admin obj
        admin.setServiceProviderList(serviceProviderList);
        adminRepository1.save(admin) ;

        return admin ;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{

        ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get() ;

        List<Country> countryList = serviceProvider.getCountryList() ;

        Country country = new Country() ;
        //country.setCountryName(countryName);

        countryList.add(country) ;
        return serviceProvider ;
    }
}
