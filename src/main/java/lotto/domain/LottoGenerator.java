package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoConstraints.*;

public class LottoGenerator {
    public void generateLottos(Lottos lottos, TotalPurchaseAmount totalPurchaseAmount) {
        for(int i = 0; i < totalPurchaseAmount.getValue()/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
