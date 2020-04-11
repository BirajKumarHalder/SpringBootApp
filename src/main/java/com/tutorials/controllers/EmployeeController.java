package com.tutorials.controllers;

import com.tutorials.services.impls.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(value = "retrieve-employee")
    public ResponseEntity<String> retrieveAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

}
