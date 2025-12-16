package com.example;

import com.example.rules.RuleEngine;

public class AdvancedBankAccountService {

    private final RuleEngine ruleEngine;

    public AdvancedBankAccountService(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void withdrawWithRules(BankAccount account, int amount) {
        AmountValidator.validatePositive(amount);
        ruleEngine.validateAll(account, amount);
        account.withdraw(amount);
    }

    public void depositSafe(BankAccount account, int amount) {
        AmountValidator.validatePositive(amount);
        account.deposit(amount);
    }
}
