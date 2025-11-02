package lotto.exception;

public enum ErrorCode {
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    LOTTO_SIZE_INVALID("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_INVALID("[ERROR] 로또 번호는 1~45 사이의 정수입니다."),
    BONUS_NUMBER_RANGE_INVALID("[ERROR] 보너스 번호는 1~45 사이의 정수입니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_RANGE_INVALID("[ERROR] 로또 당첨 번호는 1~45 사이의 정수입니다."),
    TOTAL_PURCHASE_AMOUNT_UNIT_INVALID("[ERROR] 로또 총 구입금액은 1000원 단위입니다."),
    TOTAL_PURCHASE_AMOUNT_RANGE_INVALID("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
