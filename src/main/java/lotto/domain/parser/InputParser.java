package lotto.domain.parser;

import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public int parseTotalPurchaseAmount(String totalPurchaseAmount) {
        try {
            return Integer.parseInt(totalPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.TOTAL_PURCHASE_AMOUNT_FORMAT_INVALID.getMessage());
        }
    }

    public List<Integer> parseLottoWinningNumbers(String inputLottoWinningNumbers) {
        String[] numbers = inputLottoWinningNumbers.split(",", -1);
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        try {
            for (String number : numbers) {
                lottoWinningNumbers.add(Integer.parseInt(number.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_UNIT_FORMAT_INVALID.getMessage());
        }
        return lottoWinningNumbers;
    }

    public int parseLottoBonusNumber(String inputLottoBonusNumber) {
        try {
            return Integer.parseInt(inputLottoBonusNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_FORMAT_INVALID.getMessage());
        }
    }
}
