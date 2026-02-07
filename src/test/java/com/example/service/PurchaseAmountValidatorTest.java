package com.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PurchaseAmountValidatorTest {
    @Test
    @DisplayName("구입 금액이 양의 1000원 단위가 아니면 예외를 던진다")
    void throwsExceptionWhenPurchaseAmountIsNotPositiveThousandUnit() {
        PurchaseAmountValidator validator = new PurchaseAmountValidator();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(1500));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
