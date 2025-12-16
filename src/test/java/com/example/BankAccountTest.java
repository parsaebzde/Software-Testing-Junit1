package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    void testDepositSuccess() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-200));
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000));
    }
}
