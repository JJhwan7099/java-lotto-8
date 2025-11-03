package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void 금액만큼_로또_생성() {
        LottoGenerator g = new LottoGenerator();
        Lottos lottos = g.generateLottos(new TotalPurchaseAmount(3000));
        assertThat(lottos.getAllLottos()).hasSize(3);
    }
}
