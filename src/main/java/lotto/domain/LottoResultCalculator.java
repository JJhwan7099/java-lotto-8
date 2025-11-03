package lotto.domain;

public class LottoResultCalculator {
    public LottoResult calculateRank(Lottos lottos, LottoWinningNumbers lottoWinningNumbers, LottoBonusNumber lottoBonusNumber) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos.getAllLottos()) {
            int matchedCount = lottoWinningNumbers.getMatchedCount(lotto);
            boolean isBonusMatched = lottoBonusNumber.getIsBonusMatched(lotto);

            LottoRank lottoRank = LottoRank.findRank(matchedCount, isBonusMatched);
            lottoResult.addRank(lottoRank);
        }
        return lottoResult;
    }
}
