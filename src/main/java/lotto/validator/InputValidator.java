package lotto.validator;

import java.util.List;

public class InputValidator {

    public static void validateTotalPurchaseAmount(String totalPurchaseAmount) {
        if (!totalPurchaseAmount.matches("\\d+") || totalPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    public static void validateLottoWinningNumbers(List<Integer> lottoWinningNumbers) {
        if (lottoWinningNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
    }
}
