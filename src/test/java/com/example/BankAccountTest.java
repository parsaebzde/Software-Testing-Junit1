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
    void testWithdrawSuccess() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        assertThrows(IllegalStateException.class,
                () -> account.withdraw(2000));
    }

    @Test
    void transactionListShouldIncreaseAfterDeposit() {
        account.deposit(200);
        assertEquals(1, account.getTransactions().size());
    }

    @Test
    void transactionTypeShouldBeCorrect() {
        account.withdraw(100);
        Transaction t = account.getTransactions().get(0);
        assertEquals(TransactionType.WITHDRAW, t.getType());
    }
}
