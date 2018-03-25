package com.example.demo.controller;

import com.example.demo.model.captialone.Account;
import com.example.demo.model.captialone.Bill;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultAccount;
import com.example.demo.model.captialone.result.ResultBill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("bill")
public class BillController {
    @ResponseBody
    @RequestMapping("/list")
    public String billList() {
        RestTemplate restTemplate = new RestTemplate();

        ResultBill resultBill = restTemplate.getForObject(
                ResourceConstants.route + "bills" + ResourceConstants.api_key, ResultBill.class
        );
        return resultBill.getResults().get(0).toString();
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Bill bill = restTemplate.getForObject(
                ResourceConstants.route + "bills/" + id + ResourceConstants.api_key, Bill.class
        );
        return bill.toString();
    }

}
