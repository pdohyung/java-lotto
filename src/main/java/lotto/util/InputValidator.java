package lotto.util;

import java.util.Arrays;
import java.util.List;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.*;

public class InputValidator {
    public static int validateInputAmount(String input) {
        int inputAmount = convertStringToInteger(input);
        return validateOneThousandWon(inputAmount);
    }

    public static List<Integer> validateInputWinningNumbers(String input) {
        return splitInputWinningNumbersByComma(input);
    }

    private static List<Integer> splitInputWinningNumbersByComma(String input) {
        if (input.startsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_MESSAGE.getErrorMessage());
        }
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_MESSAGE.getErrorMessage());
        }
        return Arrays.stream(input.split(COMMA))
                .mapToInt(InputValidator::convertStringToInteger)
                .boxed()
                .toList();
    }

    private static int convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE.getErrorMessage());
        }
    }

    private static int validateOneThousandWon(int inputAmount) {
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE.getErrorMessage());
        }
        return inputAmount;
    }
}
