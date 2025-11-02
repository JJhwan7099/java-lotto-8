package lotto.domain;

public enum LottoRank {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);







    private final int matchedCount;
    private final boolean isBonusMatched;
    private final int prizeAmount;

    LottoRank(int matchedCount, boolean isBonusMatched, int prizeAmount) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank findRank(int matchedCount, boolean isBonusMatched) {
        if(matchedCount == 6) return FIRST;
        if(matchedCount == 5 && isBonusMatched) return SECOND;
        if(matchedCount == 5) return THIRD;
        if(matchedCount == 4) return FOURTH;
        if(matchedCount == 3) return FIFTH;
        return NONE;
    }
}
