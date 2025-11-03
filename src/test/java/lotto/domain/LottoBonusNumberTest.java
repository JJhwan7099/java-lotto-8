package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusNumberTest {
    @Test
    void 당첨번호와_중복되면_예외() {
        assertThatThrownBy(() -> new LottoBonusNumber(3, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    void 보너스번호_범위를_벗어나면_예외() {
        assertThatThrownBy(() -> new LottoBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.BONUS_NUMBER_RANGE_INVALID.getMessage());
    }
}
