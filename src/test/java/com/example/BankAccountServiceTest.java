package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountServiceTest {

    private BankAccountService service;
    private BankAccount accountA;
    private BankAccount accountB;

    @BeforeEach
    void setUp() {
        service = new BankAccountService();
        accountA = new BankAccount(1000);
        accountB = new BankAccount(500);
    }

    @Test
    void transferShouldMoveMoneyBetweenAccounts() {
        service.transfer(accountA, accountB, 300);

        assertEquals(700, accountA.getBalance());
        assertEquals(800, accountB.getBalance());
    }

    @Test
    void transferShouldThrowExceptionWhenBalanceIsInsufficient() {
        assertThrows(InsufficientBalanceException.class,
                () -> service.transfer(accountA, accountB, 2000));
    }

    @Test
    void calculateTotalDepositsShouldReturnCorrectValue() {
        accountA.deposit(200);
        accountA.deposit(300);

        int totalDeposits = service.calculateTotalDeposits(accountA);

        assertEquals(500, totalDeposits);
    }

    @Test
    void calculateTotalWithdrawalsShouldReturnCorrectValue() {
        accountA.withdraw(100);
        accountA.withdraw(200);

        int totalWithdrawals = service.calculateTotalWithdrawals(accountA);

        assertEquals(300, totalWithdrawals);
    }
}
