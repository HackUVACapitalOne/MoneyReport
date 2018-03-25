package com.example.demo.controller;

import com.example.demo.model.captialone.Merchant;
import com.example.demo.model.captialone.ResourceConstants;
import com.example.demo.model.captialone.Transfer;
import com.example.demo.model.captialone.result.ResultTransfer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
@RequestMapping("transfer")
public class TransferController {
    @RequestMapping("/list")
    public String billList(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        ResultTransfer resultTransfer = restTemplate.getForObject(
                ResourceConstants.route + "transfers" + ResourceConstants.api_key, ResultTransfer.class
        );
        ArrayList<Transfer> transfers = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            transfers.add(resultTransfer.getResults().get(i));
        }
        model.addAttribute("transfers", transfers);
        return "model/transfer/list";
    }

    @ResponseBody
    @RequestMapping("/detail/{id}")
    public String accountDetail(@PathVariable("id") String id, Model model){
        RestTemplate restTemplate = new RestTemplate();

        Transfer transfer = restTemplate.getForObject(
                ResourceConstants.route + "transfers/" + id + ResourceConstants.api_key, Transfer.class
        );
        return transfer.toString();
    }
}
