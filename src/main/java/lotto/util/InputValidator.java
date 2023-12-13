package lotto.util;

import static lotto.util.ErrorMessage.INVALID_AMOUNT_MESSAGE;
import static lotto.util.ErrorMessage.INVALID_NUMBER_FORMAT_MESSAGE;

public class InputValidator {
    public static int validateInputAmount(String input) {
        int inputAmount = convertStringToInteger(input);
        return validateOneThousandWon(inputAmount);
    }

    private static int convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE.getErrorMessage());
        }
    }

    private static int validateOneThousandWon(int inputAmount) {
        if (inputAmount % 1_000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE.getErrorMessage());
        }
        return inputAmount;
    }
}
