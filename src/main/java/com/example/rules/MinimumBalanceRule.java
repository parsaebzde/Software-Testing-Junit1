package com.example.rules;

import com.example.BankAccount;
import com.example.InsufficientBalanceException;

public class MinimumBalanceRule implements AccountRule {

    private final int minimumBalance;

    public MinimumBalanceRule(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void validate(BankAccount account, int amount) {
        if (account.getBalance() - amount < minimumBalance) {
            throw new InsufficientBalanceException(
                    account.getBalance(), amount);
        }
    }

    @Override
    public String getRuleName() {
        return "Minimum Balance Rule";
    }
}
