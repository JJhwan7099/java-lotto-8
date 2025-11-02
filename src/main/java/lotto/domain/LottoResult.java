package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            this.result.put(rank, 0);
        }
    }

    public void addRank(LottoRank rank) {
        this.result.put(rank, this.result.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public int getTotalPrize() {
        int totalPrize = 0;
        for(Map.Entry<LottoRank, Integer> entry : this.result.entrySet()) {
            totalPrize += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        return totalPrize;
    }
}
