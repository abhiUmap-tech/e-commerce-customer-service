package com.example.customer_service.service;

import java.util.List;

import com.example.customer_service.dto.CustomerDto;

public interface ICustomerService {

    String registerCustomer(CustomerDto customerDto);

    List<CustomerDto> findAllCustomer();

    CustomerDto findCustomerById(String id);

    String updateCustomer(String id, CustomerDto customerDto);

    String deleteCustomerById(String id);

    String deleteAllCustomer();

    List<CustomerDto> findCustomerByFirstName(String firstName);

    List<CustomerDto> findCustomerByCity(String city);

    List<CustomerDto> findCustomerByState(String state);

    List<CustomerDto> findCustomerByCountry(String country);




}
