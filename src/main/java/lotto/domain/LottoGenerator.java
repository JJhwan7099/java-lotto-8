package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.parser.InputParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.domain.LottoConstraints.*;

public class LottoGenerator {

    private final Lottos lottos;

    public LottoGenerator(Lottos lottos) {
        this.lottos = lottos;
    }

    public void generateLottos(TotalPurchaseAmount totalPurchaseAmount) {
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
