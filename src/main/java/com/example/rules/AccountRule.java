package com.example.rules;

import com.example.BankAccount;

public interface AccountRule {

    void validate(BankAccount account, int amount);

    String getRuleName();
}
