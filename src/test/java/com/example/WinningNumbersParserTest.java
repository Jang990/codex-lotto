package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningNumbersParserTest {
    @Test
    @DisplayName("쉼표로 구분된 당첨 번호 문자열을 숫자 목록으로 파싱한다")
    void parseCommaSeparatedWinningNumbers() {
        WinningNumbersParser parser = new WinningNumbersParser();

        List<Integer> result = parser.parse("1,2,3,4,5,6");

        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }
}
