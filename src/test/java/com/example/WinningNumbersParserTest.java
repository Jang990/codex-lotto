package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningNumbersParserTest {
    @Test
    @DisplayName("쉼표로 구분된 당첨 번호 문자열을 숫자 목록으로 파싱한다")
    void parseCommaSeparatedWinningNumbers() {
        WinningNumbersParser parser = new WinningNumbersParser();

        Lotto result = parser.parse("1,2,3,4,5,6");

        assertEquals(java.util.List.of(1, 2, 3, 4, 5, 6), result.numbers());
    }

    @Test
    @DisplayName("당첨 번호 개수가 6개가 아니면 예외를 던진다")
    void winningNumbersCountMustBeSix() {
        WinningNumbersParser parser = new WinningNumbersParser();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("1,2,3,4,5")
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("당첨 번호 범위가 1부터 45를 벗어나면 예외를 던진다")
    void winningNumbersMustBeInRangeOneToFortyFive() {
        WinningNumbersParser parser = new WinningNumbersParser();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("1,2,3,4,5,46")
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외를 던진다")
    void winningNumbersMustNotContainDuplicates() {
        WinningNumbersParser parser = new WinningNumbersParser();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("1,2,3,4,5,5")
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
