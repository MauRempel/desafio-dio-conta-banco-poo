package com.yourbank.model.account;

import java.math.BigDecimal;

public interface IAccount {
    void withdraw(BigDecimal value);
    void deposit(BigDecimal value);
    BigDecimal getBalance();
    void addTransaction(Transaction transaction);
}
