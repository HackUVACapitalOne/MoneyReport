package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Withdrawal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultWithdrawal {
    private ArrayList<Withdrawal> results;

    public ResultWithdrawal() {
    }

    public ArrayList<Withdrawal> getResults() {
        return results;
    }

    public void setResults(ArrayList<Withdrawal> results) {
        this.results = results;
    }
}
