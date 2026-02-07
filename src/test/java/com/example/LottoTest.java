package com.example;

import com.example.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @Test
    @DisplayName("로또 한 장은 1부터 45 범위의 중복 없는 6개 번호로 구성된다")
    void lottoHasSixUniqueNumbersInRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(6, lotto.numbers().size());
        assertEquals(6, lotto.numbers().stream().distinct().count());
        assertTrue(lotto.numbers().stream().allMatch(number -> number >= 1 && number <= 45));
    }
}
