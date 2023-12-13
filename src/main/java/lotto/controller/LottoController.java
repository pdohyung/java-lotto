package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoNumbers;
import lotto.domain.enums.LottoPrize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

import static lotto.util.Constants.PERCENT_FORMAT;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        int amount = inputView.inputAmount();
        List<Lotto> lottoTicket = buy(amount);
        outputView.printLottoTicket(lottoTicket);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        EnumMap<LottoPrize, Integer> lottoResult = result(winningLottoNumbers, lottoTicket);
        outputView.printLottoResult(lottoResult, calculateProfit(lottoResult, amount));
    }

    public List<Lotto> buy(int amount) {
        return new LottoTicket(amount).getLottoTicket();
    }

    public EnumMap<LottoPrize, Integer> result(WinningLottoNumbers winningLottoNumbers, List<Lotto> lottoTicket) {
        return new LottoResult(winningLottoNumbers, lottoTicket).getLottoResult();
    }

    public double calculateProfit(EnumMap<LottoPrize, Integer> lottoResult, int amount) {
        double totalPrize = lottoResult.keySet().stream()
                .mapToDouble(prize -> prize.getPrize() * lottoResult.get(prize))
                .sum();
        return totalPrize / amount * PERCENT_FORMAT;
    }
}
