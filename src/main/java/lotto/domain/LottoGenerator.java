package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.parser.InputParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {

    private final Lottos lottos;

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public LottoGenerator(Lottos lottos) {
        this.lottos = lottos;
    }

    public void generateLottos(TotalPurchaseAmount totalPurchaseAmount) {
        for(int i = 0; i < totalPurchaseAmount.getValue()/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
