package com.example;

public class AmountValidator {

    public static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}
