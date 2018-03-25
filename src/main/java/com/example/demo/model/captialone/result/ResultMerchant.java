package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Merchant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultMerchant {
    private ArrayList<Merchant> results;

    public ResultMerchant() {
    }

    public ArrayList<Merchant> getResults() {
        return results;
    }

    public void setResults(ArrayList<Merchant> results) {
        this.results = results;
    }
}
