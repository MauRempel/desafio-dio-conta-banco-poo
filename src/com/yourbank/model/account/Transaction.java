package com.yourbank.model.account;

import java.math.BigDecimal;

public class Transaction {
    private String type;
    private BigDecimal amount;

    public Transaction(String type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " - R$ " + amount;
    }
}
