package lotto.domain;

public class LottoResultCalculator {
    public LottoResult calculateRank(Lottos lottos, LottoWinningNumbers lottoWinningNumbers) {
        LottoResult lottoResult = new LottoResult();
        for(Lotto lotto: lottos.getAllLottos()) {
            int matchedCount = lottoWinningNumbers.getMatchedCount(lotto);
            boolean isBonusMatched = lottoWinningNumbers.getIsBonusMatched(lotto);

            LottoRank lottoRank = LottoRank.findRank(matchedCount, isBonusMatched);
            lottoResult.addRank(lottoRank);
        }
        return lottoResult;
    }
}
