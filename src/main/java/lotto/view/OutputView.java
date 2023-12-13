package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static java.text.MessageFormat.format;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";
    private static final String LOTTO_TICKET_MESSAGE_FORMAT = "\n{0}개를 구매했습니다.";

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printLottoTicket(List<Lotto> lottoTicket) {
        System.out.println(format(LOTTO_TICKET_MESSAGE_FORMAT, lottoTicket.size()));
        lottoTicket.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }
}