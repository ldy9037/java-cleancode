package domain.attendance;

import java.util.stream.IntStream;

public class Attendance {

    public static final char[] ATTENDANCE_TYPE = {'A', 'L', 'P'};

    private final char type;

    Attendance(char type) {
        validate(type);
        this.type = type;
    }

    public char getType() {
        return type;
    }

    private void validate(char type) {
        if (!hasType(type)) {
            throw new IllegalArgumentException("출석 유형은 A, L, P 중 하나여야 합니다.");
        }    
    }

    private boolean hasType(char type) {
        return IntStream.range(0, ATTENDANCE_TYPE.length)
                        .mapToObj(i -> ATTENDANCE_TYPE[i])
                        .anyMatch(c -> c == type);
    }
}
