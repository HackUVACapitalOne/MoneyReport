package com.example.demo.controller;

import com.example.demo.model.captialone.Merchant;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultMerchant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("merchant")
public class MerchantController {
    @ResponseBody
    @RequestMapping("/list")
    public String billList() {
        RestTemplate restTemplate = new RestTemplate();

        ResultMerchant resultMerchant = restTemplate.getForObject(
                ResourceConstants.route + "merchants" + ResourceConstants.api_key, ResultMerchant.class
        );
        return resultMerchant.getResults().get(0).toString();
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Merchant merchant = restTemplate.getForObject(
                ResourceConstants.route + "merchants/" + id + ResourceConstants.api_key, Merchant.class
        );
        return merchant.toString();
    }
}
