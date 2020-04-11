package com.tutorials.services.impls;

import com.tutorials.clients.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeClient employeeClient;

    public String getAllEmployee() {
        return employeeClient.getAllEmployee();
    }

}
