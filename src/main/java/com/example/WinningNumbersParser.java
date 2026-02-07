package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * 당첨 번호 입력 문자열을 쉼표 기준 숫자 목록으로 파싱한다.
 */
public class WinningNumbersParser {
    public Lotto parse(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(winningNumbers);
    }
}
