package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 던진다")
    void bonusNumberMustNotDuplicateWinningNumbers() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningLotto(winningNumbers, 6)
        );

        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 기준으로 구매 로또의 등수를 판정한다")
    void judgeRankByWinningAndBonusNumbers() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        assertEquals(LottoRank.FIRST, winningLotto.judge(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertEquals(LottoRank.SECOND, winningLotto.judge(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        assertEquals(LottoRank.THIRD, winningLotto.judge(new Lotto(List.of(1, 2, 3, 4, 5, 8))));
        assertEquals(LottoRank.FOURTH, winningLotto.judge(new Lotto(List.of(1, 2, 3, 4, 8, 9))));
        assertEquals(LottoRank.FIFTH, winningLotto.judge(new Lotto(List.of(1, 2, 3, 8, 9, 10))));
        assertEquals(LottoRank.MISS, winningLotto.judge(new Lotto(List.of(1, 2, 8, 9, 10, 11))));
    }
}
