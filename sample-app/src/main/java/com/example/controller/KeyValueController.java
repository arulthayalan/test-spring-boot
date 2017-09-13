package com.example.controller;

import com.example.model.KeyValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KeyValueController {

    private static final Logger LOG = LoggerFactory.getLogger(KeyValueController.class);

    @RequestMapping(value = "/keyvalue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType
            .APPLICATION_JSON_UTF8_VALUE)
    public String test(@Valid @RequestBody KeyValue keyValue, HttpServletRequest request) {

        LOG.debug("/keyvalue api");


        Map<String, String> input = keyValue.getDataField();

        if (input instanceof HashMap) {
            LOG.debug("hashmap instance");
        }

        System.out.println("Key:" + keyValue.getKey());

        if (input != null) {
            input.forEach((k, v) -> {
                LOG.debug("Key:" + k + ",Value:" + v);
            });
        }

        return "success";
    }

    @RequestMapping("/stringList")
    @ResponseBody
    public ResponseEntity<List<String>> stringList() {
        return new ResponseEntity<List<String>>(Arrays.asList("A", "B", "C", "D"), HttpStatus.OK);
    }
}
