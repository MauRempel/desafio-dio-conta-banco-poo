package com.yourbank.model.account;

import com.yourbank.model.client.Client;

public class SavingsAccount extends Account {
    public SavingsAccount(Client client) {
        super(client);
    }
    @Override
    public String toString() {
        return "Savings Account{" +
                "agency = " + getAgency() +
                ", account = " + getAccount() +
                ", balance = " + getBalance() +
                ", client = " + getClient().getName() +
                '}';
    }
}
