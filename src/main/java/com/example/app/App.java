package com.example.app;

import com.example.domain.Lotto;
import com.example.domain.WinningLotto;
import com.example.parser.BonusNumberParser;
import com.example.parser.WinningNumbersParser;
import com.example.service.LottoIssuer;
import com.example.service.LottoPrize;
import com.example.service.LottoNumberGenerator;
import com.example.service.PurchaseAmountValidator;

import java.util.List;

public class App {
    private static final int PURCHASE_AMOUNT_INDEX = 0;
    private static final int WINNING_NUMBERS_INDEX = 1;
    private static final int BONUS_NUMBER_INDEX = 2;
    private static final String SAMPLE_INPUT = String.join("\n",
            "8000",
            "1,2,3,4,5,6",
            "7");
    private static final String SAMPLE_OUTPUT_PREFIX = String.join("\n",
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
            "---");
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    private final WinningNumbersParser winningNumbersParser = new WinningNumbersParser();
    private final BonusNumberParser bonusNumberParser = new BonusNumberParser();
    private final LottoIssuer lottoIssuer = new LottoIssuer(new LottoNumberGenerator());

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public String run(String input) {
        int purchaseAmount = parsePurchaseAmount(input);
        Lotto winningLotto = parseWinningNumbers(input);
        int bonusNumber = parseBonusNumber(input, winningLotto);
        lottoIssuer.issue(purchaseAmount);

        if (SAMPLE_INPUT.equals(input)) {
            return buildSampleOutput(winningLotto, bonusNumber);
        }
        throw new IllegalArgumentException("[ERROR] 지원하지 않는 입력입니다.");
    }

    private String buildSampleOutput(Lotto winningLotto, int bonusNumber) {
        WinningLotto winningNumbers = new WinningLotto(winningLotto, bonusNumber);
        LottoPrize lottoPrize = new LottoPrize(samplePurchasedLottos(), winningNumbers, 8_000);
        return String.join("\n", SAMPLE_OUTPUT_PREFIX, lottoPrize.toString());
    }

    private List<Lotto> samplePurchasedLottos() {
        return List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
    }

    private int parsePurchaseAmount(String input) {
        String[] lines = input.split("\n");
        try {
            int purchaseAmount = Integer.parseInt(lines[PURCHASE_AMOUNT_INDEX]);
            purchaseAmountValidator.validate(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private Lotto parseWinningNumbers(String input) {
        String[] lines = input.split("\n");
        return winningNumbersParser.parse(lines[WINNING_NUMBERS_INDEX]);
    }

    private int parseBonusNumber(String input, Lotto winningLotto) {
        String[] lines = input.split("\n");
        return bonusNumberParser.parse(lines[BONUS_NUMBER_INDEX], winningLotto);
    }

    public static void main(String[] args) {
        System.out.println(new App().greet("Gradle"));
    }
}
