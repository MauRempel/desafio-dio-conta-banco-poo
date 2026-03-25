package com.yourbank.model.bank;

import com.yourbank.model.account.Account;

import java.util.List;

public class Bank {

    private String name = "YourBank";
    private List<Account> accounts;

    public String getName() {
        return name;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
