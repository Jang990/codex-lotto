package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.LottoRank;
import com.example.domain.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 여러 장의 구매 로또를 등수별로 집계한다.
 */
public class LottoRankCounter {
    public Map<LottoRank, Integer> count(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();
        for (Lotto purchasedLotto : purchasedLottos) {
            LottoRank rank = winningLotto.judge(purchasedLotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }
}
