package com.example.rules;

import com.example.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    private final List<AccountRule> rules = new ArrayList<>();

    public void addRule(AccountRule rule) {
        rules.add(rule);
    }

    public void validateAll(BankAccount account, int amount) {
        for (AccountRule rule : rules) {
            rule.validate(account, amount);
        }
    }

    public List<String> getActiveRules() {
        List<String> names = new ArrayList<>();
        for (AccountRule rule : rules) {
            names.add(rule.getRuleName());
        }
        return names;
    }
}
