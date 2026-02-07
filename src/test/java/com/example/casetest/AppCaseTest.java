package com.example.casetest;

import com.example.app.App;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppCaseTest {
    @Test
    @DisplayName("실행 예시 입력을 넣으면 예시 출력 형식을 반환한다")
    void returnsExpectedOutputForSampleInput() {
        App app = new App();
        String input = String.join("\n",
                "8000",
                "1,2,3,4,5,6",
                "7");
        String expected = String.join("\n",
                "8개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[1, 3, 5, 14, 22, 45]",
                "",
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다.");

        assertEquals(expected, app.run(input));
    }

    @Test
    @DisplayName("구입금액이 1000원 단위가 아니면 에러로 시작하는 예외를 던진다")
    void throwsExceptionForInvalidPurchaseAmountUnit() {
        App app = new App();
        String input = String.join("\n",
                "8001",
                "1,2,3,4,5,6",
                "7");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> app.run(input));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 에러로 시작하는 예외를 던진다")
    void throwsExceptionForInvalidWinningNumberCount() {
        App app = new App();
        String input = String.join("\n",
                "8000",
                "1,2,3,4,5",
                "7");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> app.run(input));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 에러로 시작하는 예외를 던진다")
    void throwsExceptionForDuplicateWinningNumbers() {
        App app = new App();
        String input = String.join("\n",
                "8000",
                "1,2,3,4,5,5",
                "7");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> app.run(input));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 에러로 시작하는 예외를 던진다")
    void throwsExceptionForDuplicateBonusNumber() {
        App app = new App();
        String input = String.join("\n",
                "8000",
                "1,2,3,4,5,6",
                "6");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> app.run(input));
        assertTrue(exception.getMessage().startsWith("[ERROR]"));
    }
}
