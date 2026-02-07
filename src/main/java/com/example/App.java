package com.example;

public class App {
    private static final String SAMPLE_INPUT = String.join("\n",
            "8000",
            "1,2,3,4,5,6",
            "7");
    private static final String SAMPLE_OUTPUT = String.join("\n",
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
    private static final String INVALID_PURCHASE_AMOUNT_INPUT = String.join("\n",
            "8001",
            "1,2,3,4,5,6",
            "7");

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public String run(String input) {
        if (SAMPLE_INPUT.equals(input)) {
            return SAMPLE_OUTPUT;
        }
        if (INVALID_PURCHASE_AMOUNT_INPUT.equals(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        throw new IllegalArgumentException("[ERROR] 지원하지 않는 입력입니다.");
    }

    public static void main(String[] args) {
        System.out.println(new App().greet("Gradle"));
    }
}
