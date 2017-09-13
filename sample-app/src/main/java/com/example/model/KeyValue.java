package com.example.model;

import com.example.support.MyMapDeserializer;
import com.example.validator.MapSafeHtml;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;
import java.util.Map;

public class KeyValue {


    @MapSafeHtml
    @JsonDeserialize(using = MyMapDeserializer.class)
    private Map<String, String> dataField;

    @NotNull
    @SafeHtml
    private String key;

    public Map<String, String> getDataField() {
        return dataField;
    }

    public void setDataField(Map<String, String> dataFields) {
        this.dataField = dataFields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
