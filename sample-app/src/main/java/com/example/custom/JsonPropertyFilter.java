package com.example.custom;

import com.example.model.Payment;
import com.example.model.Transaction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by p711679 on 21/09/2015.
 */
@Service("jsonPropertyFilter")
public class JsonPropertyFilter extends SimpleBeanPropertyFilter {

    private static final Logger LOG = LoggerFactory.getLogger(JsonPropertyFilter.class);

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
            throws Exception {
        if (include(writer)) {
           /* if (!writer.getName().equals("type")) {
                writer.serializeAsField(pojo, jgen, provider);
                LOG.debug("inside non type");
                return;
            }*/
            if (pojo instanceof Payment) {
                String paymentType = ((Payment) pojo).getType();
                if (!paymentType.equalsIgnoreCase("UNKNOWN")) {
                    LOG.debug("inside non unknownn");
                    writer.serializeAsField(pojo, jgen, provider);
                }
            } else if (pojo instanceof Transaction) {
                Double amount = ((Transaction) pojo).getAmount();
                if (amount > -1) {
                    LOG.debug("inside non unknownn");
                    writer.serializeAsField(pojo, jgen, provider);
                }
            } else {
                writer.serializeAsField(pojo, jgen, provider);
            }

        }

    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return true;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return true;
    }
}
