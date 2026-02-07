package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {
    @Test
    @DisplayName("일치 개수와 보너스 일치 여부로 1등부터 미당첨까지 판정한다")
    void judgesRankFromMatchCountAndBonusMatch() {
        assertEquals(LottoRank.FIRST, LottoRank.from(6, false));
        assertEquals(LottoRank.SECOND, LottoRank.from(5, true));
        assertEquals(LottoRank.THIRD, LottoRank.from(5, false));
        assertEquals(LottoRank.FOURTH, LottoRank.from(4, false));
        assertEquals(LottoRank.FIFTH, LottoRank.from(3, false));
        assertEquals(LottoRank.MISS, LottoRank.from(2, false));
    }
}
