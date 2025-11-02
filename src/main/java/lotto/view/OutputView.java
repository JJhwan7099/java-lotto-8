package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.TotalPurchaseAmount;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("#,###");

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

    public void printResult(LottoResult lottoResult, int totalPurchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        printRankResults(lottoResult);
        printProfitRate(lottoResult, totalPurchaseAmount);
    }

    private void printRankResults(LottoResult lottoResult) {
        printRankResult(LottoRank.FIFTH, lottoResult);
        printRankResult(LottoRank.FOURTH, lottoResult);
        printRankResult(LottoRank.THIRD, lottoResult);
        printRankResult(LottoRank.SECOND, lottoResult);
        printRankResult(LottoRank.FIRST, lottoResult);
    }

    private void printRankResult(LottoRank rank, LottoResult lottoResult) {
        System.out.println(rank.getDescription() + " ("
                + MONEY_FORMAT.format(rank.getPrizeAmount())+"원) - "
                + lottoResult.getResult().get(rank) + "개");
    }

    private void printProfitRate(LottoResult lottoResult, int totalPurchaseAmount) {
        float profitRate = (float) Math.round(((float) lottoResult.getTotalPrize() / totalPurchaseAmount) * 100 * 100) / 100;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
