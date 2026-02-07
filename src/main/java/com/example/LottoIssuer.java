package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 구입 금액으로 발행 장수를 계산하고 여러 장의 로또를 발행한다.
 */
public class LottoIssuer {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoIssuer(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> issue(int purchaseAmount) {
        int ticketCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int count = 0; count < ticketCount; count++) {
            issuedLottos.add(lottoNumberGenerator.generate());
        }
        return issuedLottos;
    }
}
