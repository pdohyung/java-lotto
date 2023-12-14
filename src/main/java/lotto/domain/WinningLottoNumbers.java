package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.List;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE;

public class WinningLottoNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoRange(List.of(bonusNumber));
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isValidRange = numbers.stream()
                .allMatch(num -> num >= LOTTO_START_NUMBER && num <= LOTTO_END_NUMBER);

        if (!isValidRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
    }
}