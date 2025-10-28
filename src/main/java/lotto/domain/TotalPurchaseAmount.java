package lotto.domain;

public class TotalPurchaseAmount {

    private final int value;

    public TotalPurchaseAmount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 총 구입금액은 1000원 단위입니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
