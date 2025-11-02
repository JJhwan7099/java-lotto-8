package lotto.domain;

public class LottoResultCalculator {
    private final LottoWinningNumbers lottoWinningNumbers;
    private final Lottos lottos;

    public LottoResultCalculator(LottoWinningNumbers lottoWinningNumbers, Lottos lottos) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.lottos = lottos;
    }

    public LottoResult calculateRank() {
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
