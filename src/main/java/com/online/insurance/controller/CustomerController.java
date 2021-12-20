package com.online.insurance.controller;

import com.online.insurance.model.Customer;
import com.online.insurance.service.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @param dob format is yyyy-MM-dd'T'HH:mm:ss.SSSXXX — for example, "2000-10-31T01:30:00.000-05:00"
     * @return all customers that match criteria
     */
    @GetMapping("/getWithDob")
    @ResponseBody
    public List<Customer> getAllWithDOB(@RequestParam("dob")
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dob) {
        return customerService.getAllCustomersWithDOB(dob);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestParam("firstName") String firstName,
                            @RequestParam("secondName") String secondName,
                            @RequestParam("dateOfBirth") String dob,
                            @RequestParam("rating") Integer rating) {
        customerService.createCustomer(firstName, secondName, dob, rating);
    }
}
