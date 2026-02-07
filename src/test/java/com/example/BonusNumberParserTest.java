package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusNumberParserTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 던진다")
    void throwsExceptionWhenBonusNumberDuplicatesWinningNumbers() {
        BonusNumberParser parser = new BonusNumberParser();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("6", List.of(1, 2, 3, 4, 5, 6))
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
