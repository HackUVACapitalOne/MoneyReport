package com.example.demo.controller;

import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.Withdrawal;
import com.example.demo.model.captialone.result.ResultWithdrawal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("withdrawals")
public class WithdrawalController {
    @ResponseBody
    @RequestMapping("/list")
    public String billList() {
        RestTemplate restTemplate = new RestTemplate();

        ResultWithdrawal resultWithdrawal = restTemplate.getForObject(
                ResourceConstants.route + "withdrawals" + ResourceConstants.api_key, ResultWithdrawal.class
        );
        return resultWithdrawal.getResults().get(0).toString();
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Withdrawal withdrawal = restTemplate.getForObject(
                ResourceConstants.route + "withdrawals/" + id + ResourceConstants.api_key, Withdrawal.class
        );
        return withdrawal.toString();
    }
}
