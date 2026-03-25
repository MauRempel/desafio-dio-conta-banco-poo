package com.yourbank.app;

import com.yourbank.model.account.Account;
import com.yourbank.model.account.CheckingAccount;
import com.yourbank.model.account.SavingsAccount;
import com.yourbank.model.account.Transaction;
import com.yourbank.model.client.Client;
import com.yourbank.service.AccountService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountService service = new AccountService();
        Map<Integer, Account> accounts = new HashMap<>();

        Client client1 = new Client("José");
        Client client2 = new Client("Maria");

        Account checkingAcc1 = new CheckingAccount(client1);
        accounts.put(checkingAcc1.getAccount(), checkingAcc1);
        Account checkingAcc2 = new CheckingAccount(client2);
        accounts.put(checkingAcc2.getAccount(), checkingAcc2);
        Account savingsAcc1 = new SavingsAccount(client2);
        accounts.put(savingsAcc1.getAccount(), savingsAcc1);

        boolean running = true;

        while(running){
            System.out.println("\n=== YOUR BANK ===");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Transfer");
            System.out.println("4 - Statement");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Deposit amount");
                    BigDecimal depositValue = readBigDecimal(scanner);
                    checkingAcc1.deposit(depositValue);
                    System.out.println("Deposit successful!");
                    break;
                case 2:
                    System.out.println("Withdraw amount");
                    BigDecimal withdrawValue = readBigDecimal(scanner);
                    checkingAcc1.withdraw(withdrawValue);
                    System.out.println("Withdraw successful!");
                    break;
                case 3:
                    System.out.println("Transfer amount");
                    BigDecimal transferValue = readBigDecimal(scanner);
                    service.transfer(checkingAcc1, checkingAcc2, transferValue);
                    System.out.println("Transfer successful!");
                    break;
                case 4:
                    System.out.println("\nAvailable Accounts: ");
                    for(Account cc : accounts.values()) {
                        System.out.println("Account " + cc.getAccount() + " | Client " + cc.getClient().getName());
                    }
                    System.out.println("Enter Account number: ");
                    int accNumber = scanner.nextInt();
                    Account selectedAccount = accounts.get(accNumber);

                    if(selectedAccount == null){
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.println("--- Statement ---");
                    for(Transaction t : selectedAccount.getTransactions()){
                        System.out.println(t);
                    }
                    System.out.println("Actual Balance: R$" + selectedAccount.getBalance()
                    );
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }


        }
        scanner.close();


    }

    private static BigDecimal readBigDecimal(Scanner scanner){
        String input = scanner.next().replace(",", ".");
        return new BigDecimal(input);

    }
}
