package com.example.customer_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    // Personal Details
    private String firstName;
    private String lastName;
    private String gender; // Male, Female, Other
    private String dateOfBirth; // Format: YYYY-MM-DD

    // Contact Information
    private String city;
    private String state;
    private String country;



}
