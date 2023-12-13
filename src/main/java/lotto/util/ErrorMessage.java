package lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT_MESSAGE("숫자 형식이 아닙니다."),
    INVALID_AMOUNT_MESSAGE("올바른 구입 금액이 아닙니다."),
    INVALID_WINNING_NUMBERS_MESSAGE("올바른 당첨 번호가 아닙니다");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
