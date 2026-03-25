package com.yourbank.model.account;

import com.yourbank.exception.InsufficientBalanceException;
import com.yourbank.model.client.Client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements IAccount {

    private static final int AGENCY = 1;
    private static int ACCOUNT = 1;

    private final int agency;
    private final int account;
    private BigDecimal balance;
    private final Client client;

    private List<Transaction> transactions = new ArrayList<>();

    public Account(Client client) {
        if(client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.agency = Account.AGENCY;
        this.account = ACCOUNT++;
        this.balance = BigDecimal.ZERO;
        this.client = client;
    }

    public int getAgency() {
        return agency;
    }

    public int getAccount() {
        return account;
    }

    @Override
    public void withdraw(BigDecimal value) {
        validatePositiveValue(value);
        ensureSufficientBalance(value);

        this.balance = normalize(this.balance.subtract(value));
        transactions.add(new Transaction("WITHDRAW", value));

    }

    @Override
    public void deposit(BigDecimal value) {
        validatePositiveValue(value);
        this.balance = normalize(this.balance.add(value));
        transactions.add(new Transaction("DEPOSIT", value));
    }
    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }

    private BigDecimal normalize(BigDecimal value){
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void validatePositiveValue(BigDecimal value){
        if(value == null || value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Must be greater than 0");
        }
    }
    private void ensureSufficientBalance(BigDecimal value){
        if(this.balance.compareTo(value) < 0){
            throw new InsufficientBalanceException("Insufficient balance");
        }
    }

    public Client getClient() {
        return client;
    }

}
