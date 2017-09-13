package com.example.controller;

import com.example.model.KeyValue;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class KeyValueController {

    @RequestMapping(value = "/keyvalue", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public String test(@Valid @RequestBody KeyValue keyValue, HttpServletRequest request) {

        System.out.println("/keyvalue api");
        Map<String, String> input = keyValue.getDataFields();

        System.out.println("Key:" + keyValue.getKey());

        if (input != null) {
            input.forEach((k, v) -> {
                System.out.println("Key:" + k + ",Value:" + v);
            });
        }

        return "success";
    }
}
