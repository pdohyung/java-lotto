package lotto.domain.enums;

public enum LottoPrize {
    PRIZE_1ST(6, 2_000_000_000),
    PRIZE_2ND(5, 30_000_000),
    PRIZE_3ND(5, 1_500_000),
    PRIZE_4TH(4, 50_000),
    PRIZE_5TH(3, 5_000),
    NONE(0, 0);

    private final int matchingCount;
    private final long prize;

    LottoPrize(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }
}
