package com.example;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(int balance, int amount) {
        super("Cannot withdraw " + amount + 
              ". Current balance is " + balance);
    }
}
