package com.example.demo.controller;

import com.example.demo.model.captialone.Customer;
import com.example.demo.model.captialone.ResourceConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @ResponseBody
    @RequestMapping("/")
    public String showIndex() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> customerResponse =
                restTemplate.exchange(ResourceConstants.route + "customers" + ResourceConstants.api_key,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
                        });
        return customerResponse.getBody().toString();
    }

    @PostMapping("/")
    public String createCustomer(){

    }
}
