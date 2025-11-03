package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> numbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.numbers = winningNumbers;
    }

    public int getMatchedCount(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchedCount = 0;

        for(Integer number: lottoNumbers) {
            if(numbers.contains(number)) matchedCount++;
        }

        return matchedCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6)
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_SIZE_INVALID.getMessage());
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
}
