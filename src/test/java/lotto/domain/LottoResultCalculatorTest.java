package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {
    @Test
    void 등수계산_정상() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoWinningNumbers w = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonus = new LottoBonusNumber(7, w.getNumbers());

        LottoResultCalculator c = new LottoResultCalculator();
        LottoResult r = c.calculateRank(lottos, w, bonus);

        assertThat(r.getCount(LottoRank.FIRST)).isEqualTo(1);
    }
}
