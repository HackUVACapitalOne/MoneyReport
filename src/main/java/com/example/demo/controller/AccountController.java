package com.example.demo.controller;

import com.example.demo.model.captialone.Account;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("account")
public class AccountController {

    @ResponseBody
    @RequestMapping("/list")
    public String accountList() {
        RestTemplate restTemplate = new RestTemplate();

        ResultAccount resultAccount = restTemplate.getForObject(
                ResourceConstants.route + "accounts" + ResourceConstants.api_key, ResultAccount.class
        );
        return resultAccount.getResults().get(0).toString();
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Account account = restTemplate.getForObject(
                ResourceConstants.route + "accounts/" + id + ResourceConstants.api_key, Account.class
        );
        return account.toString();
    }
}
