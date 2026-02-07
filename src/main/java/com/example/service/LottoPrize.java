package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.LottoRank;
import com.example.domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 구매 로또와 당첨 로또를 받아 당첨 통계와 총 당첨금을 함께 계산한다.
 */
public class LottoPrize {
    private static final Map<LottoRank, Long> PRIZE_BY_RANK = createPrizeByRank();
    private final Map<LottoRank, Integer> rankCounts;
    private final long totalPrize;

    public LottoPrize(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        this.rankCounts = initializeRankCounts();
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoRank rank = winningLotto.judge(purchasedLotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        this.totalPrize = calculateTotalPrize(rankCounts);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double calculateProfitRate(int purchaseAmount) {
        double rawProfitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(rawProfitRate * 10) / 10.0;
    }

    @Override
    public String toString() {
        return String.join("\n",
                "3개 일치 (5,000원) - " + rankCounts.get(LottoRank.FIFTH) + "개",
                "4개 일치 (50,000원) - " + rankCounts.get(LottoRank.FOURTH) + "개",
                "5개 일치 (1,500,000원) - " + rankCounts.get(LottoRank.THIRD) + "개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(LottoRank.SECOND) + "개",
                "6개 일치 (2,000,000,000원) - " + rankCounts.get(LottoRank.FIRST) + "개");
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> rankCounts) {
        long totalPrize = 0L;
        for (Map.Entry<LottoRank, Integer> entry : rankCounts.entrySet()) {
            totalPrize += PRIZE_BY_RANK.get(entry.getKey()) * entry.getValue();
        }
        return totalPrize;
    }

    private static Map<LottoRank, Long> createPrizeByRank() {
        Map<LottoRank, Long> prizeByRank = new EnumMap<>(LottoRank.class);
        prizeByRank.put(LottoRank.FIRST, 2_000_000_000L);
        prizeByRank.put(LottoRank.SECOND, 30_000_000L);
        prizeByRank.put(LottoRank.THIRD, 1_500_000L);
        prizeByRank.put(LottoRank.FOURTH, 50_000L);
        prizeByRank.put(LottoRank.FIFTH, 5_000L);
        prizeByRank.put(LottoRank.MISS, 0L);
        return prizeByRank;
    }
}
