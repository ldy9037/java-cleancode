package domain.attendance;

public class Attendance {
    
    private final AttendanceType attendanceType;

    Attendance(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    public AttendanceType getType() {
        return attendanceType;
    }
}
