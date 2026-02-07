package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호가 1부터 45 범위를 벗어나면 예외를 던진다")
    void bonusNumberMustBeInRangeOneToFortyFive() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningLotto(winningNumbers, 46)
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
