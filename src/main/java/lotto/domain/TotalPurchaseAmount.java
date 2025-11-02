package lotto.domain;

import lotto.exception.ErrorCode;

public class TotalPurchaseAmount {

    private final int value;

    public TotalPurchaseAmount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        validateAmountUnit(value);
        validateAmountRange(value);
    }

    private void validateAmountUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.TOTAL_PURCHASE_AMOUNT_UNIT_INVALID.getMessage());
        }
    }

    private void validateAmountRange(int value) {
        if(value < 1000) {
            throw new IllegalArgumentException(ErrorCode.TOTAL_PURCHASE_AMOUNT_RANGE_INVALID.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
