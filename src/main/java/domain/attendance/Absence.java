package domain.attendance;

public class Absence {
    public static final int MINIMUM_COUNT = 0;

    private int count = 0;

    Absence(int count) {
        addCount(count);
    }

    public int getCount() {
        return count;
    }

    public void addCount(int count) {
        validate(count);
        this.count += count;
    }

    private void validate(int count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException(String.format("지각 횟수는 0 이상의 정수만 지정할 수 있습니다.", MINIMUM_COUNT));
        }
    }

    private boolean isValid(int count) {
        return (count >= MINIMUM_COUNT);
    }

}
