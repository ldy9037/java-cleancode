package domain.attendance;

import java.util.Map;

public class AttendanceRule {
    public static final int ALLOWED_ABSENCE_COUNT = 3;

    private int score;
    private int absence;

    AttendanceRule() {
        this.score = 0;
        this.absence = 0;
    }

    /*
     * 명령 쿼리 원칙을 따르지 않음.
     * score 요청을 별도의 인터페이스로 분리하는 것은 어떨지?
     */
    public void calculate(Map<Attendance, Integer> attendanceStatus) {
        for (Attendance attendance : attendanceStatus.keySet()) {
            reflect(attendance, attendanceStatus.get(attendance));
        }
    }

    public int getScore() {
        if (absence > ALLOWED_ABSENCE_COUNT) {
            return 0;
        }

        return score; 
    }

    private void reflect(Attendance attendance, int count) {
        if (attendance.getType() == 'A') {
            score += count;
        } 

        if (attendance.getType() == 'L') {
            absence += count / 3;
        } 

        if (attendance.getType() == 'P') {
            score -= count;
            absence += count;
        } 
    }

}
