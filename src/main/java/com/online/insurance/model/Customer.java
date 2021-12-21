package com.online.insurance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class Customer {
    private @Id String id;
    private final String firstName;
    private final String secondName;
    private final LocalDate dateOfBirth;
    private final Integer rating;

    public Customer(String firstName, String secondName,
                    LocalDate dateOfBirth, Integer rating) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(secondName, customer.secondName) && Objects.equals(dateOfBirth, customer.dateOfBirth) && Objects.equals(rating, customer.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, dateOfBirth, rating);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", rating=" + rating +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getRating() {
        return rating;
    }
}
