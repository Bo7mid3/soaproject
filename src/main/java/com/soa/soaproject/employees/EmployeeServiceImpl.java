package com.soa.soaproject.employees;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void initEmployees() {
        if (employeeRepository.count() > 20)
            return;
        IntStream.range(0, 60).forEach(i -> employeeRepository.save(Employee.generateFake()));
    }
}
