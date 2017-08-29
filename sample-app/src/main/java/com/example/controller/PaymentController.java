package com.example.controller;


import com.example.custom.JsonPropertyFilter;
import com.example.model.Payment;
import com.example.model.PaymentType;
import com.example.service.IBeanCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by p711679 on 21/09/2015.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @Autowired private IBeanCreator beanCreator;

    @Autowired private JsonPropertyFilter propertyFilter;


    @RequestMapping(value = "/domestic/transaction", method = RequestMethod.GET)
    @ResponseBody
    public Object domesticTransaction() throws JsonProcessingException {
        LOG.debug("INSIDE domestic transaction");
        final double amount = 100;
        FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false);
        Payment payment = beanCreator.createPaymentWithTransaction(PaymentType.DOMESTIC, amount);

       // MappingJacksonValue value = new MappingJacksonValue(payment);
        //value.setFilters(filters);

        return payment;
    }

    @RequestMapping(value = "/filter/domestic/transactions", method = RequestMethod.GET)
    @ResponseBody
    public Object transactionList() throws JsonProcessingException {
        LOG.debug("INSIDE domestic transaction list");
        final  double amount1 = 10;
        final  double amount2 = 1;

        Payment d = beanCreator.createPaymentWithTransaction(PaymentType.DOMESTIC, -1);
        Payment i = beanCreator.createPaymentWithTransaction(PaymentType.INTERNATIONAL, amount1);
        Payment u = beanCreator.createPaymentWithTransaction(PaymentType.UNKNOWN, amount2);

        List<Payment> list = new ArrayList<>();
        list.add(d);
        list.add(i);
        list.add(u);

      SimpleFilterProvider filters = new SimpleFilterProvider();
        filters.addFilter("typeFilter", new JsonPropertyFilter());
        filters.addFilter("amountFilter", new JsonPropertyFilter());

        filters.setFailOnUnknownId(false);

        MappingJacksonValue value = new MappingJacksonValue(list);
        value.setFilters(filters);

        return value;
    }
}
