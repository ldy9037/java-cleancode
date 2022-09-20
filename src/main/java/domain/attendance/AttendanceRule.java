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
    public int calculate (Map<Attendance, Integer> attendanceStatus) {
        for (Attendance attendance : attendanceStatus.keySet()) {
            reflect(attendance, attendanceStatus.get(attendance));
        }

        return getScore();
    }

    private int getScore() {
        if (absence > ALLOWED_ABSENCE_COUNT) {
            return 0;
        }

        return score; 
    }

    /*
     * 점수 반영하는 부분. 네이밍으로는 내부 동작을 파악하기 힘듬.
     * absence와 score를 조건따라 사용하기도 하고 안하기도 함. 
     * 이 경우 책임을 분리할 수 있을지? (상태는 공유)
     * 인터페이스는 같고 내부 동작만 바뀜. -> 추상 메서드 및 인터페이스 고려할 수 있음.
     */
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
