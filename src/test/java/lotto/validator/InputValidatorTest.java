package lotto.validator;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    void 구입금액_숫자만_허용() {
        assertThatThrownBy(() -> inputValidator.validateTotalPurchaseAmountFormat("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.TOTAL_PURCHASE_AMOUNT_FORMAT_INVALID.getMessage());
    }

    @Test
    void 당첨번호_숫자와_쉼표만_허용() {
        assertThatThrownBy(() -> inputValidator.validateLottoWinningNumbersFormat("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WINNING_NUMBER_FORMAT_INVALID.getMessage());
    }

    @Test
    void 보너스번호_숫자만_허용() {
        assertThatThrownBy(() -> inputValidator.validateLottoBonusNumberFormat("1a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.BONUS_NUMBER_FORMAT_INVALID.getMessage());
    }
}
