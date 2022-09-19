package domain.attendance;

import java.util.List;
import java.util.stream.IntStream;

public class Attendance {
    
    private static final char[] TYPES = {'A', 'L', 'P'};

    private final char attendanceType;

    Attendance(char attendanceType) {
        validate(attendanceType);
        this.attendanceType = attendanceType;
    }

    public char getType() {
        return attendanceType;
    }

    private void validate(char type) {
        if (!isValid(type)) {
            throw new IllegalArgumentException("출석 유형은 A,L,P 중 하나여야 합니다.");
        }
    }

    private boolean isValid(char type) {
        return IntStream.range(0, TYPES.length)
                        .mapToObj(i -> TYPES[i])
                        .anyMatch(c -> c == type);
    }
}
