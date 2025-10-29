package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.parser.InputParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private final int totalPurchaseAmount;

    public LottoGenerator(TotalPurchaseAmount totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount.getValue();
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalPurchaseAmount/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
