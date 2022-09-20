package domain.attendance;

import java.util.Objects;
import java.util.stream.IntStream;

public class Attendance {
    
    public static final char[] TYPES = {'A', 'L', 'P'};

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Attendance)) return false;
        
        Attendance that = (Attendance) obj;

        return attendanceType == that.attendanceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceType);
    }
}
