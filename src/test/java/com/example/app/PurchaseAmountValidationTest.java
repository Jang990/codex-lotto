package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PurchaseAmountValidationTest {
    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외를 던진다")
    void throwsExceptionWhenPurchaseAmountIsNotThousandUnit() {
        App app = new App();
        String input = String.join("\n",
                "1500",
                "1,2,3,4,5,6",
                "7");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> app.run(input));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
