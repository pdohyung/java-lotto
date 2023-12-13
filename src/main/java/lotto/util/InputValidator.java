package lotto.util;

import static lotto.util.ErrorMessage.INVALID_NUMBER_FORMAT_MESSAGE;

public class InputValidator {
    public static int validateInputAmount(String input) {
        return convertStringToInteger(input);
    }

    private static int convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE.getErrorMessage());
        }
    }
}
