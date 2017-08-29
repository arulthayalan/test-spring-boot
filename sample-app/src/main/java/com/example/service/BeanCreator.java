package com.example.service;

import com.example.model.Payment;
import com.example.model.PaymentType;
import com.example.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by p711679 on 21/09/2015.
 */
@Service("beanCreator")
public class BeanCreator implements IBeanCreator {

    @Override
    public Payment createPaymentWithTransaction(PaymentType paymentType, double amount) {


        Transaction transaction = new Transaction();
        transaction.setId(1);
        transaction.setTransactionDate(new Date());
        transaction.setAmount(amount);
        transaction.setFromAccount("08505-12345678");
        transaction.setToAccount("030567-4563456");

        final int paymentId = 101;

        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setDate(new Date());
        payment.addTransaction(transaction);

        switch (paymentType) {

            case DOMESTIC:
                payment.setType("DOMESTIC");
                break;
            case INTERNATIONAL:
                payment.setType("INTERNATIONAL");
                break;
            default:
                payment.setType("UNKNOWN");

        }


        return payment;
    }
}
