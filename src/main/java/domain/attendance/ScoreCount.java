package domain.attendance;

public class ScoreCount {

    private final int count;

    ScoreCount(int count) {
        validate(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException("점수는 0 이상의 정수로만 생성 가능합니다.");
        }
    }

    private boolean isValid(int count) {
        return (count >= 0);
    }
}
