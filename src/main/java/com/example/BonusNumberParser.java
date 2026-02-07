package com.example;

/**
 * 보너스 번호 입력 문자열을 숫자로 파싱하고 당첨 번호 중복을 검증한다.
 */
public class BonusNumberParser {
    public int parse(String input, Lotto winningLotto) {
        int bonusNumber = Integer.parseInt(input);
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNumber;
    }
}
