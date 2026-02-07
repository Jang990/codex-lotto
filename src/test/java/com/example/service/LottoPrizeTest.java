package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {
    @Test
    @DisplayName("구매 로또 목록과 당첨 로또로 등수별 집계와 총 당첨금을 함께 계산한다")
    void calculatePrizeSummary() {
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
        LottoPrize lottoPrize = new LottoPrize(purchasedLottos, winningLotto);
        String expectedStatistics = String.join("\n",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");

        assertEquals(expectedStatistics, lottoPrize.toString());
        assertEquals(2_031_555_000L, lottoPrize.getTotalPrize());
    }

    @Test
    @DisplayName("구입 금액이 있으면 toString에 당첨 통계와 수익률 문구를 함께 반환한다")
    void toStringReturnsStatisticsWithProfitRateWhenPurchaseAmountExists() {
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
        LottoPrize lottoPrize = new LottoPrize(purchasedLottos, winningLotto, 8_000);
        String expectedOutput = String.join("\n",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 25394437.5%입니다.");

        assertEquals(expectedOutput, lottoPrize.toString());
    }

    @Test
    @DisplayName("구입 금액 기준 수익률을 소수점 둘째 자리에서 반올림해 계산한다")
    void calculateProfitRateRoundedAtSecondDecimalPlace() {
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
        LottoPrize lottoPrize = new LottoPrize(purchasedLottos, winningLotto);

        double profitRate = lottoPrize.calculateProfitRate(8_000);

        assertEquals(25_394_437.5, profitRate);
    }
}
