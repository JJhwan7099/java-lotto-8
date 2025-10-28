package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputTotalPurchaseAmount() {
        return Console.readLine();
    }

    public String inputLottoWinningNumbers() {
        return Console.readLine();
    }

    public String inputLottoBonusNumber() {
        return Console.readLine();
    }
}
