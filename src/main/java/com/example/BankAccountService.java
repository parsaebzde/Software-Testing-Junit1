package com.example;

import java.util.List;

public class BankAccountService {

    /**
     * Transfers money from one account to another.
     * This method demonstrates service-level business logic.
     */
    public void transfer(BankAccount from, BankAccount to, int amount) {

        AmountValidator.validatePositive(amount);

        if (from.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    from.getBalance(), amount);
        }

        from.withdraw(amount);
        to.deposit(amount);
    }

    /**
     * Calculates total deposited amount from transaction history.
     */
    public int calculateTotalDeposits(BankAccount account) {

        List<Transaction> transactions = account.getTransactions();
        int total = 0;

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                total += t.getAmount();
            }
        }

        return total;
    }

    /**
     * Calculates total withdrawn amount from transaction history.
     */
    public int calculateTotalWithdrawals(BankAccount account) {

        List<Transaction> transactions = account.getTransactions();
        int total = 0;

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.WITHDRAW) {
                total += t.getAmount();
            }
        }

        return total;
    }
}
