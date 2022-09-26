package domain.attendance_v2;

public class Attendances {
    private final AttendanceFactory attendanceFactory;

    public Attendances(AttendanceFactory attendanceFactory) {
        this.attendanceFactory = attendanceFactory;
    }

    public int calculate(String attendances) {
        int result = 0;

        for (Type attendance : attendanceFactory.createTypeList(attendances)) {
            result += attendance.score();
        }

        return result;
    }
}
