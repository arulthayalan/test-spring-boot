package com.example.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.util.Date;

/**
 * Created by p711679 on 21/09/2015.
 */
@JsonFilter("amountFilter")
public class Transaction {

    private int id;

    private Date transactionDate;

    private Double amount;

    private String fromAccount;

    private String toAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }


}
