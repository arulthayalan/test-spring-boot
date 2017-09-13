package com.example.model;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class KeyValue {

    private Map<String, String> dataFields;

    @NotNull
    private String key;

    public Map<String, String> getDataFields() {
        return dataFields;
    }

    public void setDataFields(Map<String, String> dataFields) {
        this.dataFields = dataFields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
