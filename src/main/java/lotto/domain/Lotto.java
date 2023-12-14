package lotto.domain;

import lotto.util.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.Constants.*;
import static lotto.util.ErrorMessage.INVALID_LOTTO_LENGTH;
import static lotto.util.ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateDuplicate(numbers);
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
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        int originalCount = numbers.size();
        int uniqueCount = uniqueNumbers.size();

        if (originalCount != uniqueCount) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_DUPLICATE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
