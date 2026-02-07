package com.example.domain;

/**
 * 일치 개수와 보너스 일치 여부로 로또 등수를 판정한다.
 */
public enum LottoRank {
    MISS,
    FIFTH,
    FOURTH,
    THIRD,
    SECOND,
    FIRST;

    public static LottoRank from(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatched) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }
}
