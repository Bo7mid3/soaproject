package com.soa.soaproject.employees;

import com.github.javafaker.Faker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

    public static Employee generateFake() {
        Faker faker = new Faker();
        Employee fakeEmployee = new Employee();
        fakeEmployee.setFirstName(faker.name().firstName());
        fakeEmployee.setLastName(faker.name().lastName());
        fakeEmployee.setEmail(faker.internet().emailAddress());
        fakeEmployee.setPhoneNumber(faker.phoneNumber().phoneNumber());
        return fakeEmployee;
    } 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
