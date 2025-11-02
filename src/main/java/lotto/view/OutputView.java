package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.TotalPurchaseAmount;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printRequestTotalPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printRequestLottoWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printRequestLottoBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(String.join(", ", lotto.getNumbers().toString()));
        }
    }

    public void printLottoResults(Map<LottoRank, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        for(Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            if(entry.getKey() == LottoRank.NONE) continue;
            System.out.print(entry.getKey().getMatchedCount() + "개 일치");
            if(entry.getKey().isBonusMatched()) System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%,d원) - ", entry.getKey().getPrizeAmount());
            System.out.println(entry.getValue() + "개");
        }
    }

    public void printProfitRate(int totalPrize, int totalPurchaseAmount) {
        float profitRate = (float) totalPrize / totalPurchaseAmount * 100;
        profitRate = (float) Math.round(profitRate * 100) / 100;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
