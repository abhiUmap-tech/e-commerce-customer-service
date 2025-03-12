package com.example.customer_service.config;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private int statusCode;

    private String errorMsg;

    private LocalDateTime timeStamp;

}
