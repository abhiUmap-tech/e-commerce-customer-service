package com.example.customer_service.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.dto.CustomerDto;
import com.example.customer_service.service.ICustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final ICustomerService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewCustomer(@RequestBody CustomerDto customerDto) {
        var responseBody = service.registerCustomer(customerDto);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<CustomerDto>> findAllCustomers() {
        var responseBody = service.findAllCustomer();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findCustomerById/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable String id){
        var customerDetails = service.findCustomerById(id);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerDto> updateCustomerDetails(@RequestBody CustomerDto customerDto){
        var responseBody = service.updateCustomer(customerDto);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable String id){
        var responseBody = service.deleteCustomerById(id);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findCustomersByFirstName/{firstName}")
    public ResponseEntity<List<CustomerDto>> findCustomerByFirstNamEntity(@PathVariable String firstName){
        var responseBody = service.findCustomerByFirstName(firstName);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findCustomersByCity/{city}")
    public ResponseEntity<List<CustomerDto>> findCustomerByCity(@PathVariable String city){
        var responseBody = service.findCustomerByCity(city);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findCustomersByState/{state}")
    public ResponseEntity<List<CustomerDto>> findCustomerByState(@PathVariable String state){
        var responseBody = service.findCustomerByState(state);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findCustomersByCountry/{country}")
    public ResponseEntity<List<CustomerDto>> findCustomerByCountry(@PathVariable String country){
        var responseBody = service.findCustomerByState(country);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


}
