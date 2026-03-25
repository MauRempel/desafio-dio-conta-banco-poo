package com.yourbank.service;


import com.yourbank.model.account.IAccount;
import com.yourbank.model.account.Transaction;

import java.math.BigDecimal;

public class AccountService {

    public void transfer(IAccount origin, IAccount destination, BigDecimal value){



        origin.withdraw(value);
        destination.deposit(value);

        origin.addTransaction(new Transaction("TRANSFER OUT", value));
        destination.addTransaction(new Transaction("TRANSFER IN", value));
    }
}
