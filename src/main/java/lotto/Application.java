package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.parser.InputParser;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputParser inputParser = new InputParser();
        LottoGenerator lottoGenerator = new LottoGenerator();
        InputValidator inputValidator = new InputValidator();
        LottoController lottoController = new LottoController(inputView, outputView, inputParser, lottoGenerator, inputValidator);
        lottoController.run();
    }
}
