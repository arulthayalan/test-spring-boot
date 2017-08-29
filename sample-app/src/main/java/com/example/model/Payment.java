package com.example.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by p711679 on 21/09/2015.
 */
@JsonFilter("typeFilter")
public class Payment {

    private long paymentId;

    private String type;

    private Date date;

    private List<Transaction> transactionList = new ArrayList<>();

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
}
