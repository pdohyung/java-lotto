package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.List;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.INVALID_LOTTO_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_LENGTH.getErrorMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean isValidRange = numbers.stream()
                .allMatch(num -> num >= LOTTO_START_NUMBER && num <= LOTTO_END_NUMBER);

        if (!isValidRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
