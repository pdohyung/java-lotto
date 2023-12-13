package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import javax.sound.midi.Soundbank;
import java.util.List;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public int inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return InputValidator.validateInputAmount(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return InputValidator.validateInputWinningNumbers(Console.readLine());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return InputValidator.validateInputBonusNumber(Console.readLine());
    }
}
