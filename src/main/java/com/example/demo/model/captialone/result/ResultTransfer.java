package com.example.demo.model.captialone.result;

import com.example.demo.model.captialone.Transfer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultTransfer {
    private ArrayList<Transfer> results;

    public ResultTransfer() {
    }

    public ArrayList<Transfer> getResults() {
        return results;
    }

    public void setResults(ArrayList<Transfer> results) {
        this.results = results;
    }
}
