package com.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private int balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(int balance) {
        AmountValidator.validatePositive(balance);
        this.balance = balance;
    }

    public void deposit(int amount) {
        AmountValidator.validatePositive(amount);
        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount));
    }

    public void withdraw(int amount) {
        AmountValidator.validatePositive(amount);
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction(TransactionType.WITHDRAW, amount));
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

