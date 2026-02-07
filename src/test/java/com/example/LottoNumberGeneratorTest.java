package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호 생성기는 1부터 45 범위의 중복 없는 6개 번호를 생성한다")
    void generateValidLottoNumbers() {
        LottoNumberGenerator generator = new LottoNumberGenerator();

        Lotto lotto = generator.generate();

        assertEquals(6, lotto.numbers().size());
        assertEquals(6, lotto.numbers().stream().distinct().count());
        assertTrue(lotto.numbers().stream().allMatch(number -> number >= 1 && number <= 45));
    }
}
