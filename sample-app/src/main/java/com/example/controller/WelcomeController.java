package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by P711679 on 15/09/2015.
 */
@RestController
@RequestMapping("/home")
public class WelcomeController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "Welcome";
    }
}
