package com.example.demo.controller;

import com.example.demo.model.captialone.Customer;
import com.example.demo.model.captialone.Deposit;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultDeposit;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("deposit")
public class DepositController {
    @RequestMapping("/list")
    public String billList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResultDeposit resultDeposit = restTemplate.getForObject(
                ResourceConstants.route + "deposits" + ResourceConstants.api_key, ResultDeposit.class
        );

        ArrayList<Deposit> deposits = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            deposits.add(resultDeposit.getResults().get(i));
        }
        model.addAttribute("deposits", deposits);
        return "model/deposit/list";
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
