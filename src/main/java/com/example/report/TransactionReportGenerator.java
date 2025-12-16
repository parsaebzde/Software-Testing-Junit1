package com.example.report;

import com.example.BankAccount;
import com.example.Transaction;
import com.example.TransactionType;

import java.util.List;

public class TransactionReportGenerator {

    public String generateFullReport(BankAccount account) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Account Report ===\n");
        sb.append("Current Balance: ").append(account.getBalance()).append("\n");
        sb.append("Transactions:\n");

        List<Transaction> list = account.getTransactions();
        for (Transaction t : list) {
            sb.append("- ")
              .append(t.getTime())
              .append(" | ")
              .append(t.getType())
              .append(" | ")
              .append(t.getAmount())
              .append("\n");
        }

        sb.append("Total Transactions: ").append(list.size()).append("\n");
        return sb.toString();
    }

    public int calculateTotalByType(BankAccount account, TransactionType type) {
        int sum = 0;
        for (Transaction t : account.getTransactions()) {
            if (t.getType() == type) {
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
