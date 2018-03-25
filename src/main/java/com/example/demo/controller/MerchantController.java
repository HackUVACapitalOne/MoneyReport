package com.example.demo.controller;

import com.example.demo.model.captialone.Deposit;
import com.example.demo.model.captialone.Merchant;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.result.ResultMerchant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("merchant")
public class MerchantController {
    @RequestMapping("/list")
    public String billList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResultMerchant resultMerchant = restTemplate.getForObject(
                ResourceConstants.route + "merchants" + ResourceConstants.api_key, ResultMerchant.class
        );
        ArrayList<Merchant> merchants = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            merchants.add(resultMerchant.getResults().get(i));
        }
        model.addAttribute("merchants", merchants);
        return "model/merchant/list";
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
