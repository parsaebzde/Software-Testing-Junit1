package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BankAccount represents a simple bank account entity.
 * It contains business logic for deposit and withdraw operations
 * and keeps track of transaction history.
 */
public class BankAccount {

    private int balance;
    private final List<Transaction> transactions = new ArrayList<>();

    /**
     * Creates a new BankAccount with an initial balance.
     */
    public BankAccount(int balance) {
        AmountValidator.validatePositive(balance);
        this.balance = balance;
    }

    /**
     * Deposits a positive amount into the account.
     */
    public void deposit(int amount) {
        AmountValidator.validatePositive(amount);

        balance += amount;
        transactions.add(new Transaction(TransactionType.DEPOSIT, amount));
    }

    /**
     * Withdraws a positive amount from the account.
     * Throws exception if balance is insufficient.
     */
    public void withdraw(int amount) {
        AmountValidator.validatePositive(amount);

        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        transactions.add(new Transaction(TransactionType.WITHDRAW, amount));
    }

    /**
     * Returns the current account balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Returns an unmodifiable list of transactions.
     * This prevents external modification of internal state.
     */
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
