package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * 당첨 번호 입력 문자열을 쉼표 기준 숫자 목록으로 파싱한다.
 */
public class WinningNumbersParser {
    private static final int REQUIRED_WINNING_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<Integer> parse(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        if (winningNumbers.size() != REQUIRED_WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (winningNumbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        }

        return winningNumbers;
    }
}
