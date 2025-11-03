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
        TotalPurchaseAmount totalPurchaseAmount = requestPurchaseAmountInput();

        lottoGenerator.generateLottos(lottos, totalPurchaseAmount);
        outputView.printPurchasedLottos(lottos.getAllLottos());

        LottoWinningNumbers lottoWinningNumbers = requestWinningNumbers();
        LottoBonusNumber lottoBonusNumber = requestBonusNumber(lottoWinningNumbers);

        LottoResult lottoResult = new LottoResultCalculator().calculateRank(lottos, lottoWinningNumbers, lottoBonusNumber);
        outputView.printResult(lottoResult, totalPurchaseAmount.getValue());
    }

    private LottoBonusNumber requestBonusNumber(LottoWinningNumbers lottoWinningNumbers) {
        outputView.printRequestLottoBonusNumber();
        return inputLottoBonusNumber(lottoWinningNumbers);
    }

    private LottoWinningNumbers requestWinningNumbers() {
        outputView.printRequestLottoWinningNumbers();
        return inputLottoWinningNumbers();
    }

    private TotalPurchaseAmount requestPurchaseAmountInput() {
        outputView.printRequestTotalPurchaseAmount();
        return inputTotalPurchaseAmount();
    }

    private TotalPurchaseAmount inputTotalPurchaseAmount() {
        while (true) {
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
        while (true) {
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
        while (true) {
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
