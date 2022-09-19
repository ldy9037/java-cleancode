package domain.attendance;

import java.util.List;

public class Attendance {
    
    private static final char[] TYPE = {'A', 'L', 'P'};

    private final char attendanceType;

    Attendance(char attendanceType) {
        this.attendanceType = attendanceType;
    }

    public char getType() {
        return attendanceType;
    }
}
