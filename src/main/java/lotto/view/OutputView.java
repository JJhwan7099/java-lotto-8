package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void printRequestTotalPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequestLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(String.join(", ", lotto.getNumbers().toString()));
        }
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
