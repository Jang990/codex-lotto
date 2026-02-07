package com.example.service;

import com.example.domain.Lotto;
import com.example.domain.LottoRank;
import com.example.domain.WinningLotto;

/**
 * 구매 로또와 당첨 로또를 비교해 등수를 판정한다.
 */
public class LottoRankJudge {
    public LottoRank judge(Lotto purchasedLotto, WinningLotto winningLotto) {
        return winningLotto.judge(purchasedLotto);
    }
}
