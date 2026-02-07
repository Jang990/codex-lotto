package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * 당첨 번호 입력 문자열을 쉼표 기준 숫자 목록으로 파싱한다.
 */
public class WinningNumbersParser {
    private static final int REQUIRED_WINNING_NUMBER_COUNT = 6;

    public List<Integer> parse(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        if (winningNumbers.size() != REQUIRED_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        return winningNumbers;
    }
}
