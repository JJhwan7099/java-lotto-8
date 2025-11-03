package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void 초기_결과값은_모든_등수가_0이다() {
        for (LottoRank rank : LottoRank.values()) {
            assertThat(lottoResult.getCount(rank)).isZero();
        }
    }

    @Test
    void 특정_등수를_추가하면_해당_등수_count가_증가한다() {
        lottoResult.addRank(LottoRank.FIRST);
        lottoResult.addRank(LottoRank.FIRST);
        lottoResult.addRank(LottoRank.THIRD);

        assertThat(lottoResult.getCount(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.getCount(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    void getResult_반환값은_원본과_다른_새로운_객체다() {
        Map<LottoRank, Integer> copied = lottoResult.getResult();
        copied.put(LottoRank.FIRST, 10);

        assertThat(lottoResult.getCount(LottoRank.FIRST)).isZero();
    }

    @Test
    void getTotalPrize_정상_계산() {
        lottoResult.addRank(LottoRank.FIRST);
        lottoResult.addRank(LottoRank.SECOND);
        lottoResult.addRank(LottoRank.THIRD);

        int expectedTotal = LottoRank.FIRST.getPrizeAmount()
                + LottoRank.SECOND.getPrizeAmount()
                + LottoRank.THIRD.getPrizeAmount();

        assertThat(lottoResult.getTotalPrize()).isEqualTo(expectedTotal);
    }

    @Test
    void 수익률_계산로직_정상() {
        lottoResult.addRank(LottoRank.THIRD);

        float profitRate = lottoResult.getProfitRate(1000);

        assertThat(profitRate).isEqualTo(150000.0f);
    }
}
