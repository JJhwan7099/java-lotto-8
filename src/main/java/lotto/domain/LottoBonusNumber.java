package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.List;

public class LottoBonusNumber {
    private final int value;

    public LottoBonusNumber(int value, List<Integer> winningNumbers) {
        validateBonusNumber(value, winningNumbers);
        this.value = value;
    }

    public boolean getIsBonusMatched(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(value);
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumbers);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstraints.LOTTO_NUMBER_MIN || bonusNumber > LottoConstraints.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
