package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 500})
    void validAmountsShouldNotThrowException(int amount) {
        assertDoesNotThrow(() -> AmountValidator.validatePositive(amount));
    }
}
