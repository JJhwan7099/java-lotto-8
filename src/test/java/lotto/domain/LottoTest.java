package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    @Test
    void 로또_숫자가_정상적으로_생성된다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).containsExactlyElementsOf(numbers);
    }

    @Test
    void 로또_숫자_개수가_6개가_아니면_예외() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_SIZE_INVALID.getMessage());
    }

    @Test
    void 로또_숫자_범위_초과시_예외() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_RANGE_INVALID.getMessage());
    }

    @Test
    void 로또_숫자_중복시_예외() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.LOTTO_NUMBER_DUPLICATE.getMessage());
    }
}
