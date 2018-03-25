package com.example.demo.controller;

import com.example.demo.model.captialone.Bill;
import com.example.demo.model.captialone.Customer;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultAccount;
import com.example.demo.model.captialone.result.ResultCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @RequestMapping("/list")
    public String billList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResultCustomer resultCustomer = restTemplate.getForObject(
                ResourceConstants.route + "customers" + ResourceConstants.api_key, ResultCustomer.class
        );
        ArrayList<Customer> customers = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            customers.add(resultCustomer.getResults().get(i));
        }
        model.addAttribute("customers", customers);
        return "model/customer/list";
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Customer customer = restTemplate.getForObject(
                ResourceConstants.route + "customers/" + id + ResourceConstants.api_key, Customer.class
        );
        return customer.toString();
    }
}
