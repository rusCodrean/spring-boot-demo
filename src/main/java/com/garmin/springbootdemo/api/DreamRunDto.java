package com.garmin.springbootdemo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DreamRunDto {

    @JsonProperty("dreamRunValues")
    private List<String> dreamRunValues;

    @JsonProperty("dreamRunTotal")
    private String dreamRunTotal;

    public List<String> getDreamRunValues() {
        return dreamRunValues;
    }

    public void setDreamRunValues(List<String> dreamRunValues) {
        this.dreamRunValues = dreamRunValues;
    }

    public String getDreamRunTotal() {
        return dreamRunTotal;
    }

    public void setDreamRunTotal(String dreamRunTotal) {
        this.dreamRunTotal = dreamRunTotal;
    }

    public void addDreamValues(String dreamValue) {
        if (this.dreamRunValues == null) {
            this.dreamRunValues = new ArrayList<>();
        }

        this.dreamRunValues.add(dreamValue);
    }
}
