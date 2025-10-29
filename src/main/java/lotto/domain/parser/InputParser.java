package lotto.domain.parser;

import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<Integer> parseLottoWinningNumbers(String inputLottoWinningNumbers) {
        String[] numbers = inputLottoWinningNumbers.split(",", -1);
        List<Integer> lottoWinningNumbers = new ArrayList<>();
        try {
            for (String number : numbers) {
                lottoWinningNumbers.add(Integer.parseInt(number.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자형식이어야 합니다.");
        }

        InputValidator.validateLottoWinningNumbers(lottoWinningNumbers);

        return lottoWinningNumbers;
    }

    public int parseLottoBonusNumber(String inputLottoBonusNumber) {
        try{
            return Integer.parseInt(inputLottoBonusNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자형식이어야 합니다.");
        }
    }
}
