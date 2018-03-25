package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultAccount {
    private ArrayList<Account> results;

    public ResultAccount() {
    }

    public List<Account> getResults() {
        return results;
    }

    public void setResults(ArrayList<Account> results) {
        this.results = results;
    }
}
