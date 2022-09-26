package domain.attendance_v2;

public class Attendances {
    public static final int MAX_ALLOW_CAUTION = 9;

    private final AttendanceFactory attendanceFactory;
    private int caution = 0;

    public Attendances(AttendanceFactory attendanceFactory) {
        this.attendanceFactory = attendanceFactory;
    }

    public int calculate(String attendances) {
        int result = 0;

        for (Type attendance : attendanceFactory.createTypeList(attendances)) {
            result += attendance.score();
            caution += attendance.caution();
        }

        if (ExceededAllowedCaution() || isMinusScore(result)) return 0; 
        return result;
    }

    private boolean ExceededAllowedCaution() {
        return (caution > MAX_ALLOW_CAUTION);
    }

    private boolean isMinusScore(int score) {
        return (score < 0);
    }
}
