package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.LottoRank;
import com.example.domain.WinningLotto;

import java.util.Map;

/**
 * 구매 로또와 당첨 로또를 받아 당첨 통계와 총 당첨금을 함께 계산한다.
 */
public class LottoPrize {
    private final LottoRankCounter lottoRankCounter = new LottoRankCounter();
    private final LottoPrizeCalculator lottoPrizeCalculator = new LottoPrizeCalculator();

    public Result calculate(java.util.List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = lottoRankCounter.count(purchasedLottos, winningLotto);
        long totalPrize = lottoPrizeCalculator.calculateTotalPrize(rankCounts);
        return new Result(Map.copyOf(rankCounts), totalPrize);
    }

    public record Result(Map<LottoRank, Integer> rankCounts, long totalPrize) {
    }
}
