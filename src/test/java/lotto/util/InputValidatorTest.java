package lotto.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1e00", "abcd", ",,,,", "happy"})
    void 구매_금액이_숫자가_아닌_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1250", "22222", "500", "0"})
    void 구매_금액이_1000원_단위가_아닌_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",2,3,4,5,6", "1,2,3,4,5,"})
    void 당첨_번호_입력이_쉼표로_시작하거나_끝나는_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,e,3,4,5,6", "1,2,3,sa,5,6", "1,2,3,4, ,5", "1,,3,4,5,6"})
    void 당첨_번호_입력이_숫자가_아닌_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"e", "sa", "zz", " ", "", "!!"})
    void 보너스_번호_입력이_숫자가_아닌_경우_예외_처리(String input) {
        assertThatThrownBy(() -> InputValidator.validateInputBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}