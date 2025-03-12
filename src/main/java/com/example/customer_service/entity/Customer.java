package com.example.customer_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String id;

     // Personal Details
     private String firstName;
     private String lastName;
     private String gender; // Male, Female, Other
     private String dateOfBirth; // Format: YYYY-MM-DD

     // Contact Information
     private String city;
    private String state;
    private String country;

    // Account Details
    private String accountStatus; // Active, Inactive
    private String registrationDate; // Format: YYYY-MM-DD
    private String customerType; // Individual, Business


     


}
