package lotto.domain;

import lotto.domain.enums.LottoPrize;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static lotto.domain.enums.LottoPrize.*;
import static lotto.util.Constants.*;

public class LottoResult {
    EnumMap<LottoPrize, Integer> lottoResult;

    public LottoResult(WinningLottoNumbers winningLottoNumbers, List<Lotto> lottoTicket) {
        this.lottoResult = generationLottoResult(winningLottoNumbers, lottoTicket);
    }

    public EnumMap<LottoPrize, Integer> getLottoResult() {
        return lottoResult;
    }

    private EnumMap<LottoPrize, Integer> generationLottoResult(WinningLottoNumbers winningLottoNumbers,
                                                               List<Lotto> lottoTicket) {
        EnumMap<LottoPrize, Integer> initialLottoResult = new EnumMap<>(LottoPrize.class);

        for (LottoPrize prize : LottoPrize.values()) {
            initialLottoResult.put(prize, 0);
        }

        for (Lotto lotto : lottoTicket) {
            LottoPrize prize = determinePrize(winningLottoNumbers, lotto.getNumbers());
            initialLottoResult.put(prize, initialLottoResult.get(prize) + 1);
        }

        return initialLottoResult;
    }

    private LottoPrize determinePrize(WinningLottoNumbers winningLottoNumbers, List<Integer> lotto) {
        int matchingCount = (int) winningLottoNumbers.getWinningNumbers().stream()
                .filter(lotto::contains)
                .count();
        if (matchingCount == MATCHING_COUNT_2ND_OR_3ND) {
            return determinePrize2ndOr3rd(lotto, winningLottoNumbers.getBonusNumber());
        }
        return findLottoPrize(matchingCount);
    }

    private LottoPrize determinePrize2ndOr3rd(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            return PRIZE_2ND;
        }
        return PRIZE_3ND;
    }

    public LottoPrize findLottoPrize(int matchingCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lp -> lp.getMatchingCount() == matchingCount)
                .findFirst()
                .orElse(NONE);
    }
}
