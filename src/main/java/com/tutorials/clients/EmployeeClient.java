package com.tutorials.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeClient {

    @Autowired
    private RestTemplate restTemplate;

    public String getAllEmployee() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://dummy.restapiexample.com/api/v1/employees", String.class);
        return response.getBody();
    }
}
