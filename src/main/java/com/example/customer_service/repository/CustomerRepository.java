package com.example.customer_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer_service.entity.Customer;
import java.util.List;


public interface CustomerRepository extends MongoRepository<Customer, String>{

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByCity(String city);

    List<Customer> findByState(String state);

    List<Customer> findByCountry(String country);



}
