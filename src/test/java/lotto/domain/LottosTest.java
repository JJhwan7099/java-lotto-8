package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 로또를_추가하면_getAllLottos로_조회가능하다() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lottos.add(lotto);

        assertThat(lottos.getAllLottos()).contains(lotto);
        assertThat(lottos.getAllLottos()).hasSize(1);
    }


}