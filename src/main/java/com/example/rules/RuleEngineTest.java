package com.example.rules;

import com.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RuleEngineTest {

    private RuleEngine ruleEngine;
    private BankAccount account;

    @BeforeEach
    void setUp() {
        ruleEngine = new RuleEngine();
        ruleEngine.addRule(new MinimumBalanceRule(200));
        ruleEngine.addRule(new DailyWithdrawLimitRule(500));
        account = new BankAccount(1000);
    }

    @Test
    void withdrawWithinRulesShouldPass() {
        assertDoesNotThrow(() ->
                ruleEngine.validateAll(account, 300));
    }

    @Test
    void withdrawViolatingMinimumBalanceShouldFail() {
        assertThrows(RuntimeException.class, () ->
                ruleEngine.validateAll(account, 900));
    }

    @Test
    void withdrawExceedingDailyLimitShouldFail() {
        assertThrows(IllegalArgumentException.class, () ->
                ruleEngine.validateAll(account, 600));
    }
}
