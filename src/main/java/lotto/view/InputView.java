package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public int inputAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return InputValidator.validateInputAmount(Console.readLine());
    }
}
