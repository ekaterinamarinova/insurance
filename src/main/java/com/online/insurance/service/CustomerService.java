package com.online.insurance.service;

import com.online.insurance.model.Customer;
import com.online.insurance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomersWithDOB(LocalDate dob) {

        return repository.findAll()
                .stream()
                .filter(customer -> customer.getDateOfBirth().equals(dob))
                .collect(Collectors.toList());
    }

    public void createCustomer(String firstName,
                               String secondName,
                               String dateOfBirth,
                               Integer rating) {

        if (firstName == null || secondName == null || dateOfBirth == null || rating == null) {
            throw new IllegalArgumentException("Missing required customer parameter.");
        }

        LocalDate parsedDOB = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_DATE);
        Customer customer = new Customer(firstName, secondName, parsedDOB, rating);
        repository.save(customer);
    }
}
