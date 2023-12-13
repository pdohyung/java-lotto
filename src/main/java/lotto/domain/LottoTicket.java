package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    public LottoTicket(int amount) {
        this.lottoTicket = generationLottoTicket(amount);
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    private List<Lotto> generationLottoTicket(int amount) {
        List<Lotto> initialLottoTicket = new ArrayList<>();
        int numberLotto = amount / LOTTO_PRICE;
        for (int i = 0; i < numberLotto; i++) {
            List<Integer> lottoNumbers = generationLottoNumbers();
            Collections.sort(lottoNumbers);
            initialLottoTicket.add(new Lotto(lottoNumbers));
        }
        return initialLottoTicket;
    }

    private List<Integer> generationLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_LENGTH);
        return new ArrayList<>(lottoNumbers);
    }
}