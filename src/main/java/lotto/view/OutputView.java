package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoPrize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.text.MessageFormat.format;
import static lotto.util.Constants.LAST_PRIZE;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] {0}";
    private static final String LOTTO_TICKET_MESSAGE_FORMAT = "\n{0}개를 구매했습니다.";
    private static final String LOTTO_RESULT_START_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_PRIZE_OTHER_MESSAGE_FORMAT = "{0}개 일치 ({1}원) - {2}개";
    private static final String LOTTO_PRIZE_2ND_MESSAGE_FORMAT = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개";
    private static final String LOTTO_PROFIT_MESSAGE_FORMAT = "총 수익률은 {0}%입니다.";

    public void printErrorMessage(String errorMessage) {
        System.out.println(format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    public void printLottoTicket(List<Lotto> lottoTicket) {
        System.out.println(format(LOTTO_TICKET_MESSAGE_FORMAT, lottoTicket.size()));
        lottoTicket.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    public void printLottoResult(EnumMap<LottoPrize, Integer> lottoPrizeResult, double profit) {
        System.out.println(LOTTO_RESULT_START_MESSAGE);
        lottoPrizeResult.entrySet().stream()
                .filter(entry -> entry.getKey().getMatchingCount() >= LAST_PRIZE)
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(LottoPrize::getMatchingCount)))
                .forEach(entry -> {
                    LottoPrize prize = entry.getKey();
                    int count = entry.getValue();
                    if (prize == LottoPrize.PRIZE_2ND) {
                        System.out.println(format(LOTTO_PRIZE_2ND_MESSAGE_FORMAT, prize.getMatchingCount(),
                                prize.getPrize(), count));
                        return;
                    }
                    System.out.println(format(LOTTO_PRIZE_OTHER_MESSAGE_FORMAT, prize.getMatchingCount(),
                            prize.getPrize(), count));
                });
        BigDecimal number = new BigDecimal(profit);
        System.out.println(format(LOTTO_PROFIT_MESSAGE_FORMAT, number.setScale(1, RoundingMode.HALF_EVEN)));
    }
}