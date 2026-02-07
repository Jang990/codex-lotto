package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.LottoRank;
import com.example.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {
    @Test
    @DisplayName("구매 로또 목록과 당첨 로또로 등수별 집계와 총 당첨금을 함께 계산한다")
    void calculatePrizeSummary() {
        LottoPrize lottoPrize = new LottoPrize();
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(12, 13, 14, 15, 16, 17))
        );

        LottoPrize.Result result = lottoPrize.calculate(purchasedLottos, winningLotto);

        assertEquals(1, result.rankCounts().get(LottoRank.FIRST));
        assertEquals(1, result.rankCounts().get(LottoRank.SECOND));
        assertEquals(1, result.rankCounts().get(LottoRank.THIRD));
        assertEquals(1, result.rankCounts().get(LottoRank.FOURTH));
        assertEquals(1, result.rankCounts().get(LottoRank.FIFTH));
        assertEquals(2, result.rankCounts().get(LottoRank.MISS));
        assertEquals(2_031_555_000L, result.totalPrize());
    }
}
