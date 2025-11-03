package lotto.validator;

import lotto.exception.ErrorCode;

import java.util.List;

public class InputValidator {
    public void validateTotalPurchaseAmountFormat(String totalPurchaseAmount) {
        if (!totalPurchaseAmount.matches("\\d+") || totalPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.TOTAL_PURCHASE_AMOUNT_FORMAT_INVALID.getMessage());
        }
    }

    public void validateLottoWinningNumbersFormat(String lottoWinningNumbers) {
        if(!lottoWinningNumbers.matches("[0-9,\\s]+"))
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_FORMAT_INVALID.getMessage());
    }

    public void validateLottoBonusNumberFormat(String lottoBonusNumber) {
        if (!lottoBonusNumber.matches("\\d+") || lottoBonusNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_FORMAT_INVALID.getMessage());
        }
    }
}
