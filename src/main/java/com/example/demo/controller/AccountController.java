package com.example.demo.controller;

import com.example.demo.model.captialone.Account;
import com.example.demo.model.captialone.ResourceConstants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {

    @ResponseBody
    @RequestMapping("/")
    public String showIndex() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Account>> accountResponse =
                restTemplate.exchange(ResourceConstants.route + "accounts" + ResourceConstants.api_key,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>() {
                        });
        return accountResponse.getBody().get(0).toString();
    }
}
