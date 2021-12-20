package com.online.insurance.service;

import com.online.insurance.model.Customer;
import com.online.insurance.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomersWithDOB(LocalDateTime dob) {

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

        Customer customer = new Customer(firstName, secondName, LocalDateTime.parse(dateOfBirth), rating);
        repository.save(customer);
    }
}
