package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @Test
    void 중복시_예외() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WINNING_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    void 일치갯수_정상계산() {
        LottoWinningNumbers w = new LottoWinningNumbers(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(List.of(1,2,10,20,30,40));

        assertThat(w.getMatchedCount(lotto)).isEqualTo(2);
    }

    @Test
    void 로또번호_범위를_벗어나면_예외() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1,1,2,3,4,55)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WINNING_NUMBER_RANGE_INVALID.getMessage());
    }
}
