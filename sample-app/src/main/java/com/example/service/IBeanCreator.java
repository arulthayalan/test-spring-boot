package com.example.service;

import com.example.model.Payment;
import com.example.model.PaymentType;

/**
 * Created by p711679 on 21/09/2015.
 */
public interface IBeanCreator {

    Payment createPaymentWithTransaction(PaymentType paymentType, double amount);
}
