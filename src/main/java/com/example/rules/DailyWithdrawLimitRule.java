package com.example.rules;

import com.example.BankAccount;

public class DailyWithdrawLimitRule implements AccountRule {

    private final int dailyLimit;

    public DailyWithdrawLimitRule(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    @Override
    public void validate(BankAccount account, int amount) {
        if (amount > dailyLimit) {
            throw new IllegalArgumentException(
                    "Daily withdraw limit exceeded: " + dailyLimit);
        }
    }

    @Override
    public String getRuleName() {
        return "Daily Withdraw Limit Rule";
    }
}
