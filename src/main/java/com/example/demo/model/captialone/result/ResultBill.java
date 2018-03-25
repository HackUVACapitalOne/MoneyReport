package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Account;
import com.example.demo.model.captialone.Bill;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultBill {
    private ArrayList<Bill> results;

    public ResultBill() {
    }

    public ArrayList<Bill> getResults() {
        return results;
    }

    public void setResults(ArrayList<Bill> results) {
        this.results = results;
    }
}
