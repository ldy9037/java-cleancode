package domain.attendance;

public class AbsenceCount {
    public static final int MINIMUM_COUNT = 0;

    private int count;

    AbsenceCount(int count) {
        validate(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (isValid(count)) {
            throw new IllegalArgumentException("지각 횟수는 0 이상의 정수만 지정할 수 있습니다.");
        }
    }

    private boolean isValid(int count) {
        return (count < MINIMUM_COUNT);
    }

}
