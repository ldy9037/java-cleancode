package domain.attendance;

public class ScoreCount {
    public static final int MINIMUM_COUNT = 0;

    private int count;

    ScoreCount(int count) {
        validate(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException(String.format("점수는 %s 이상이어야 합니다.", MINIMUM_COUNT));
        }
    }

    private boolean isValid(int count) {
        return (count >= MINIMUM_COUNT);
    }
}
