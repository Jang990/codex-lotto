package com.example.service;

import com.example.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoIssuerTest {
    @Test
    @DisplayName("구입 금액에 해당하는 장수만큼 로또를 발행한다")
    void issuesLottosByPurchaseAmount() {
        LottoIssuer issuer = issuerWithFixedLotto();

        List<Lotto> issuedLottos = issuer.issue(8000);

        assertEquals(8, issuedLottos.size());
    }

    private LottoIssuer issuerWithFixedLotto() {
        Lotto fixedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumberGenerator generator = new LottoNumberGenerator() {
            @Override
            public Lotto generate() {
                return fixedLotto;
            }
        };
        return new LottoIssuer(generator);
    }
}
