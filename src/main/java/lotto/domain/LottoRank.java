package lotto.domain;

public enum LottoRank {
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2000000000, "6개 일치");

    private final int matchedCount;
    private final boolean isBonusMatched;
    private final int prizeAmount;
    private final String description;

    LottoRank(int matchedCount, boolean isBonusMatched, int prizeAmount, String description) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeAmount = prizeAmount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static LottoRank findRank(int matchedCount, boolean isBonusMatched) {
        if (matchedCount == 6) return FIRST;
        if (matchedCount == 5 && isBonusMatched) return SECOND;
        if (matchedCount == 5) return THIRD;
        if (matchedCount == 4) return FOURTH;
        if (matchedCount == 3) return FIFTH;
        return NONE;
    }
}
