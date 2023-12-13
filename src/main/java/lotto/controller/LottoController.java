package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
    }

    public List<Lotto> buy(int amount) {
        return new LottoTicket(amount).getLottoTicket();
    }
}
