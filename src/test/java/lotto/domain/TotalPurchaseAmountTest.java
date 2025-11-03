package lotto.domain;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TotalPurchaseAmountTest {
    @Test
    void 천원단위_아닐경우_예외() {
        assertThatThrownBy(() -> new TotalPurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.TOTAL_PURCHASE_AMOUNT_UNIT_INVALID.getMessage());
    }

    @Test
    void 천원이상이어야한다() {
        assertThatThrownBy(() -> new TotalPurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.TOTAL_PURCHASE_AMOUNT_RANGE_INVALID.getMessage());
    }

    @Test
    void 정상생성() {
        TotalPurchaseAmount t = new TotalPurchaseAmount(2000);
        assertThat(t.getValue()).isEqualTo(2000);
    }
}
