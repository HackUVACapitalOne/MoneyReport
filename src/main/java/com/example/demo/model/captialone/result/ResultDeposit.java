package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Deposit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDeposit {
    private ArrayList<Deposit> results;

    public ResultDeposit() {
    }

    public ArrayList<Deposit> getResults() {
        return results;
    }

    public void setResults(ArrayList<Deposit> results) {
        this.results = results;
    }
}
