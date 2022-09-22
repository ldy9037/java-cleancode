package domain.attendance;

public class Absence {
    public static final int MINIMUM_COUNT = 0;

    private final int count;

    Absence(int count) {
        validate(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }


    private void validate(int count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException("지각 횟수는 0번 이상만 지정할 수 있습니다.");
        }
    }

    private boolean isValid(int count) {
        return (count >= MINIMUM_COUNT);
    }

}
