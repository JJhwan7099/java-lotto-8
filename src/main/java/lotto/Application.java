package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.parser.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputParser inputParser = new InputParser();
        Lottos lottos = new Lottos();
        LottoGenerator lottoGenerator = new LottoGenerator(lottos);
        LottoController lottoController = new LottoController(inputView, outputView, inputParser, lottos, lottoGenerator);
        lottoController.run();
    }
}
