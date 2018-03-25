package com.example.demo.controller;

import com.example.demo.model.captialone.Account;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultAccount;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping("/list")
    public String accountList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResultAccount resultAccount = restTemplate.getForObject(
                ResourceConstants.route + "accounts" + ResourceConstants.api_key, ResultAccount.class
        );
        ArrayList<Account> accounts = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            accounts.add(resultAccount.getResults().get(i));
        }
         model.addAttribute("accounts", accounts);
        return "model/account/list";
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
