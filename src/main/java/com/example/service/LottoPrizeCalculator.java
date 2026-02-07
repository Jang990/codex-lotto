package com.example.service;

import com.example.domain.LottoRank;

import java.util.EnumMap;
import java.util.Map;

/**
 * 등수별 당첨 개수로 총 당첨금을 계산한다.
 */
public class LottoPrizeCalculator {
    private static final Map<LottoRank, Long> PRIZE_BY_RANK = createPrizeByRank();

    public long calculateTotalPrize(Map<LottoRank, Integer> rankCounts) {
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
