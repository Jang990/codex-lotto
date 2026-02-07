package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 중복 없는 1~45 범위 숫자 6개를 생성해 Lotto를 만든다.
 */
public class LottoNumberGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int REQUIRED_NUMBER_COUNT = 6;

    public Lotto generate() {
        List<Integer> candidates = new ArrayList<>();
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            candidates.add(number);
        }

        Collections.shuffle(candidates);
        List<Integer> selectedNumbers = new ArrayList<>(candidates.subList(0, REQUIRED_NUMBER_COUNT));
        Collections.sort(selectedNumbers);
        return new Lotto(selectedNumbers);
    }
}
