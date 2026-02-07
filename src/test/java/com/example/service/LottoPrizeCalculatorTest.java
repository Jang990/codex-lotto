package com.example.service;

import com.example.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeCalculatorTest {
    @Test
    @DisplayName("등수별 당첨 개수로 총 당첨금을 계산한다")
    void calculateTotalPrizeFromRankCounts() {
        LottoPrizeCalculator calculator = new LottoPrizeCalculator();
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        rankCounts.put(LottoRank.FIRST, 1);
        rankCounts.put(LottoRank.SECOND, 1);
        rankCounts.put(LottoRank.THIRD, 1);
        rankCounts.put(LottoRank.FOURTH, 1);
        rankCounts.put(LottoRank.FIFTH, 1);
        rankCounts.put(LottoRank.MISS, 2);

        long totalPrize = calculator.calculateTotalPrize(rankCounts);

        assertEquals(2_031_555_000L, totalPrize);
    }
}
