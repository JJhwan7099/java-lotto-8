package lotto.controller;

import lotto.domain.*;
import lotto.domain.parser.InputParser;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final Lottos lottos;
    private final LottoGenerator lottoGenerator;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, OutputView outputView, InputParser inputParser, Lottos lottos, LottoGenerator lottoGenerator, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.lottos = lottos;
        this.lottoGenerator = lottoGenerator;
        this.inputValidator = inputValidator;
    }

    public void run() {
        outputView.printRequestTotalPurchaseAmount();
        TotalPurchaseAmount totalPurchaseAmount = inputTotalPurchaseAmount();

        lottoGenerator.generateLottos(totalPurchaseAmount);
        outputView.printPurchasedLottos(lottos.getAllLottos());

        outputView.printRequestLottoWinningNumbers();
        LottoWinningNumbers lottoWinningNumbers = inputLottoWinningNumbers();

        outputView.printRequestLottoBonusNumber();
        LottoBonusNumber lottoBonusNumber = inputLottoBonusNumber(lottoWinningNumbers);

        LottoResult lottoResult = new LottoResultCalculator().calculateRank(lottos, lottoWinningNumbers, lottoBonusNumber);
        outputView.printResult(lottoResult, totalPurchaseAmount.getValue());
    }

    private TotalPurchaseAmount inputTotalPurchaseAmount() {
        while(true) {
            try {
                String totalPurchaseAmountInput = inputView.inputTotalPurchaseAmount();
                inputValidator.validateTotalPurchaseAmountFormat(totalPurchaseAmountInput);

                return new TotalPurchaseAmount(inputParser.parseTotalPurchaseAmount(totalPurchaseAmountInput));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoWinningNumbers inputLottoWinningNumbers() {
        while(true) {
            try {
                String inputLottoWinningNumbers = inputView.inputLottoWinningNumbers();
                inputValidator.validateLottoWinningNumbersFormat(inputLottoWinningNumbers);
                List<Integer> lottoWinningNumbers = inputParser.parseLottoWinningNumbers(inputLottoWinningNumbers);

                return new LottoWinningNumbers(lottoWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoBonusNumber inputLottoBonusNumber(LottoWinningNumbers lottoWinningNumbers) {
        while(true) {
            try {
                String inputLottoBonusNumber = inputView.inputLottoBonusNumber();
                inputValidator.validateLottoBonusNumberFormat(inputLottoBonusNumber);
                int lottoBonusNumber = inputParser.parseLottoBonusNumber(inputLottoBonusNumber);

                return new LottoBonusNumber(lottoBonusNumber, lottoWinningNumbers.getNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
