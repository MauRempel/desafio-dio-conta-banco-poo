package com.yourbank.model.account;

import com.yourbank.model.client.Client;

public class CheckingAccount extends Account {

    public CheckingAccount(Client client) {
        super(client);
    }
    @Override
    public String toString() {
        return "Checking Account{" +
                "agency = " + getAgency() +
                ", account = " + getAccount() +
                ", balance = " + getBalance() +
                ", client = " + getClient().getName() +
                '}';
    }
}
