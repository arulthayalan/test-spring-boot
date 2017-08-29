package com.example.controller;

import com.example.model.Payment;
import com.example.model.PaymentType;
import com.example.service.IBeanCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Created by p711679 on 25/09/2015.
 */
@RestController
@RequestMapping("/async/")
public class AsynchronousController {
    private static final Logger LOG = LoggerFactory.getLogger(AsynchronousController.class);

    @Autowired
    private IBeanCreator beanCreator;


    @RequestMapping(value = "/domestic/transaction", method = RequestMethod.GET)
    @ResponseBody
    public Callable<Payment> domesticTransaction() throws JsonProcessingException {
        LOG.debug("INSIDE domestic transaction");
        final double amount = 100;
        FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false);
       // Payment payment = beanCreator.createPaymentWithTransaction(PaymentType.DOMESTIC, amount);
       // return payment;

        return () -> beanCreator.createPaymentWithTransaction(PaymentType.DOMESTIC, amount);
    }
}
