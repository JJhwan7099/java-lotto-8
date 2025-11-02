package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getMatchedCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchedCount = 0;

        for(Integer number: lottoNumbers) {
            if(winningNumbers.contains(number)) matchedCount++;
        }

        return matchedCount;
    }

    public boolean getIsBonusMatched(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }


    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber);
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if(number < LottoConstraints.LOTTO_NUMBER_MIN|| number > LottoConstraints.LOTTO_NUMBER_MAX)
                throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
        HashSet<Integer> duplicateNumbers = new HashSet<>(winningNumbers);
        if(duplicateNumbers.size() != winningNumbers.size()){
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if(bonusNumber < LottoConstraints.LOTTO_NUMBER_MIN || bonusNumber > LottoConstraints.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
