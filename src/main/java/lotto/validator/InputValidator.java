package lotto.validator;

public class InputValidator {
    public static void validateTotalPurchaseAmount(String totalPurchaseAmount) {
        if (!totalPurchaseAmount.matches("\\d+") || totalPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야합니다.");
        }
    }
}
