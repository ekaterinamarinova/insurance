package com.online.insurance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public record Contract(@Id Long id, Integer customerId, Integer insuranceId,
                       String details, Double finalPrice, Integer duration,
                       LocalDateTime signUpDate, LocalDateTime validityDate) {}
