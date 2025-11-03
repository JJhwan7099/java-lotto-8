package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoConstraints.LOTTO_NUMBER_MAX;
import static lotto.domain.LottoConstraints.LOTTO_NUMBER_MIN;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicates(numbers);
        validateSize(numbers);
        validateNumberRange(numbers);
    }

    private void validateDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstraints.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_SIZE_INVALID.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_RANGE_INVALID.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }
}
