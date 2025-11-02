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

    public LottoController(InputView inputView, OutputView outputView, InputParser inputParser, Lottos lottos, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
        this.lottos = lottos;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {

        outputView.printRequestTotalPurchaseAmount();
        TotalPurchaseAmount totalPurchaseAmount = inputTotalPurchaseAmount();

        lottoGenerator.generateLottos(totalPurchaseAmount);
        outputView.printPurchasedLottos(lottos.getAllLottos());

        outputView.printRequestLottoWinningNumbers();
        List<Integer> parsedLottoWinningNumbers = inputLottoWinningNumbers();

        outputView.printRequestLottoBonusNumber();
        String inputLottoBonusNumber = inputLottoBonusNumber();

        int lottoBonusNumber = inputParser.parseLottoBonusNumber(inputLottoBonusNumber);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(parsedLottoWinningNumbers,lottoBonusNumber);

        LottoResult lottoResult = new LottoResultCalculator().calculateRank(lottos, lottoWinningNumbers);

        outputView.printLottoResults(lottoResult.getResult());
        outputView.printProfitRate(lottoResult.getTotalPrize(), totalPurchaseAmount.getValue());
    }

    private String inputLottoBonusNumber() {
        while(true) {
            try {
                return inputView.inputLottoBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private TotalPurchaseAmount inputTotalPurchaseAmount() {
        while(true) {
            try {
                String totalPurchaseAmountInput = inputView.inputTotalPurchaseAmount();
                InputValidator.validateTotalPurchaseAmount(totalPurchaseAmountInput);

                return new TotalPurchaseAmount(Integer.parseInt(totalPurchaseAmountInput));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void generateLottos(TotalPurchaseAmount totalPurchaseAmount) {
        lottoGenerator.generateLottos(totalPurchaseAmount);
    }

    private List<Integer> inputLottoWinningNumbers() {
        while(true) {
            try {
                String inputLottoWinningNumbers = inputView.inputLottoWinningNumbers();
                return inputParser.parseLottoWinningNumbers(inputLottoWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
