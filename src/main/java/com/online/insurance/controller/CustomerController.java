package com.online.insurance.controller;

import com.online.insurance.model.Customer;
import com.online.insurance.service.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String defaultPathGreet() {
        return "Hello. Here you can interact with the customer data.";
    }

    /**
     * @param dob The most common ISO Date Format yyyy-MM-dd — for example, "2000-10-31""
     * @return all customers that match criteria
     */
    @GetMapping("/customer/getWithDob")
    @ResponseBody
    public List<Customer> getAllWithDob(@RequestParam("dob")
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dob) {
        return customerService.getAllCustomersWithDOB(dob);
    }

    @PostMapping("/customer/add")
    public void addCustomer(@RequestParam("firstName") String firstName,
                            @RequestParam("secondName") String secondName,
                            @RequestParam("dateOfBirth") String dob,
                            @RequestParam("rating") Integer rating) {
        customerService.createCustomer(firstName, secondName, dob, rating);
    }
}
