package com.example.customer_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.customer_service.dto.CustomerDto;
import com.example.customer_service.entity.Customer;
import com.example.customer_service.exceptions.CustomerNotFoundException;
import com.example.customer_service.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository repo;
    private final ModelMapper modelMapper;

    @Override
    public String registerCustomer(CustomerDto customerDto) {
        return Optional.ofNullable(customerDto)
                .map(dto -> {
                    // Map DTO to Entity using Model Mapper
                    var customer = modelMapper.map(dto, Customer.class);
                    // Save the mapped entity to the repository
                    var savedCustomer = repo.save(customer);
                    // Return a confirmation message
                    return "Customer saved successfully with the ID::" + savedCustomer.getId();
                })
                .orElse("CustomerDTO cannot be Null or Empty");

    }

    @Override
    public List<CustomerDto> findAllCustomer() {
        // Fetch all the customer entities from the repo
        var customers = repo.findAll();

        // Convert the List to a Stream and Map each Customer Entity to a CustomerDto using ModelMapper
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDto findCustomerById(String id) {
        // Fetch customer entity by Id or throw a Custom Exception if not found
        var customer = repo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for the given ID::" + id));

        // Map the Customer Entity to a CustomerDto using ModelMapper
        return modelMapper.map(customer, CustomerDto.class);

    }

    @Override
    public CustomerDto updateCustomer( CustomerDto customerDto) {
       //Check with Optional of Nullable
       return Optional.ofNullable(customerDto)
            .map(dto -> {
                //Convert the DTO to Customer
                var customer = modelMapper.map(dto, Customer.class);
                //Save the converted Customer to the Repo
                var savedCustomer = repo.save(customer);
                //Convert the Customer to DTO and return
                return modelMapper.map(savedCustomer, CustomerDto.class);
            })
            .orElseThrow(() -> new CustomerNotFoundException("Customer Dto cannot be Null"));
    }

    @Override
    public String deleteCustomerById(String id) {
        // Fetch the Customer entity by Id or throw a Custom Exception if not found
        var customer = repo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found with the given ID::" + id));
        // Delete the customer entity
        repo.delete(customer);

        // Return a confirmation message
        return "Customer deleted successfully with the Id::" + id;
    }

    @Override
    public String deleteAllCustomer() {
        repo.deleteAll();
        return "All Customers deleted successfully";
    }

    @Override
    public List<CustomerDto> findCustomerByFirstName(String firstName) {
        // Wrap the result of the repository method in an Optional
        // This ensures we can handle cases where the result might be empty
        return Optional.of(repo.findByFirstName(firstName))

                // Use a filter to check if the list is not empty
                // If the list is empty, the filter will cause the Optional to become empty
                .filter(customer -> !customer.isEmpty())
                // If the filtered Optional is empty, throw a custom exception
                .orElseThrow(() -> new CustomerNotFoundException("No customer found with the first name::" + firstName))
                // Convert the list of Customer entities to a stream for processing
                .stream()
                // Map each Customer entity to a CustomerDto using ModelMapper
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                // Collect the mapped CustomerDto objects into a List
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> findCustomerByCity(String city) {
        return Optional.of(repo.findByCity(city))
                            .filter(customer -> !customer.isEmpty())
                            .orElseThrow(() -> new CustomerNotFoundException("No Customer found for the City::" + city))
                            .stream()
                            .map(customer -> modelMapper.map(customer, CustomerDto.class))
                            .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> findCustomerByState(String state) {
        return Optional.of(repo.findByState(state))
                        .filter(customer -> !customer.isEmpty())
                        .orElseThrow(() -> new CustomerNotFoundException("No Customers found for the State::" + state))
                        .stream()
                        .map(customer -> modelMapper.map(customer, CustomerDto.class))
                        .collect(Collectors.toList());
        
    }

    @Override
    public List<CustomerDto> findCustomerByCountry(String country) {
        return Optional.of(repo.findByCountry(country))
                        .filter(customers -> !customers.isEmpty())
                        .orElseThrow(() -> new CustomerNotFoundException("No Customers found for the Country::" + country))
                        .stream()
                        .map(customer -> modelMapper.map(customer, CustomerDto.class))
                        .collect(Collectors.toList());
    }

}
