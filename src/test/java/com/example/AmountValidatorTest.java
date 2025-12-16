package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AmountValidatorTest {

    @Test
    void validAmountDoesNotThrowException() {
        assertDoesNotThrow(() -> AmountValidator.validatePositive(100));
    }

    @Test
    void zeroAmountThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> AmountValidator.validatePositive(0));
    }

    @Test
    void negativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> AmountValidator.validatePositive(-50));
    }
}
