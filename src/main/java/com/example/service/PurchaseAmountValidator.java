package com.example.service;

/**
 * 구입 금액이 양의 1,000원 단위인지 검증한다.
 */
public class PurchaseAmountValidator {
    private static final int LOTTO_PRICE = 1000;

    public void validate(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
