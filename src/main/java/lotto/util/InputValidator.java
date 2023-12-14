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

    public static int validateInputBonusNumber(String input) {
        return convertStringToInteger(input);
    }

    private static List<Integer> splitInputWinningNumbersByComma(String input) {
        if (input.startsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_MESSAGE.getErrorMessage());
        }
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_MESSAGE.getErrorMessage());
        }
        List<Integer> winningNumbers = Arrays.stream(input.split(COMMA))
                .mapToInt(InputValidator::convertStringToInteger)
                .boxed()
                .toList();
        return validateWinningNumbers(winningNumbers);
    }

    private static List<Integer> validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getErrorMessage());
        }
        boolean isValidRange = winningNumbers.stream()
                .allMatch(num -> num >= LOTTO_START_NUMBER && num <= LOTTO_END_NUMBER);
        if (!isValidRange) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
        return winningNumbers;
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
