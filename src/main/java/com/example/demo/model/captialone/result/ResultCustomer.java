package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultCustomer {
    private ArrayList<Customer> results;

    public ResultCustomer() {
    }

    public ArrayList<Customer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Customer> results) {
        this.results = results;
    }
}
