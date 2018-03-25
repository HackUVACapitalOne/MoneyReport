package com.example.demo.controller;

import com.example.demo.model.captialone.Deposit;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultDeposit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("deposit")
public class DepositController {
    @ResponseBody
    @RequestMapping("/list")
    public String billList() {
        RestTemplate restTemplate = new RestTemplate();

        ResultDeposit resultDeposit = restTemplate.getForObject(
                ResourceConstants.route + "deposits" + ResourceConstants.api_key, ResultDeposit.class
        );
        return resultDeposit.getResults().get(0).toString();
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Deposit deposit = restTemplate.getForObject(
                ResourceConstants.route + "deposits/" + id + ResourceConstants.api_key, Deposit.class
        );
        return deposit.toString();
    }
}
