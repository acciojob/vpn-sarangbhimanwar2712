package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        ServiceProvider serviceProvider = new ServiceProvider(providerName,admin);

        //get list of service provider from admin
        List<ServiceProvider> serviceProviderList = admin.getServiceProviderList();
        if (serviceProviderList == null) {
            serviceProviderList = new ArrayList<ServiceProvider>();
        }
        serviceProviderList.add(serviceProvider);
        admin.setServiceProviderList(serviceProviderList);
        adminRepository1.save(admin);
        return admin;
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{

        if (CountryName.valueOf(countryName).toString() != countryName) throw new Exception("Country not found");
        ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();
        if (serviceProvider == null) throw new Exception("Invalid serviceproviderId");
        CountryName countryName1 = CountryName.valueOf(countryName);
        Country country = new Country(countryName1, serviceProvider);
        List<Country> countryList = serviceProvider.getCountryList();
        if (countryList == null) {
            countryList = new ArrayList<Country>();
        }
        countryList.add(country);
        serviceProvider.setCountryList(countryList);
        serviceProviderRepository1.save(serviceProvider);
        return serviceProvider;
    }
}
