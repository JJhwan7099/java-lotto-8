package lotto.domain;

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
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 정수입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
