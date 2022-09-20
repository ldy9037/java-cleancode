package domain.attendance;

import java.util.Map;

public class AttendanceRule {
    public static final int ALLOWED_ABSENCE_COUNT = 3;

    private RuleItemFactory ruleItemFactory;
    private int score;
    private int absence;

    AttendanceRule() {
        ruleItemFactory = new RuleItemFactory();
        this.score = 0;
        this.absence = 0;
    }

    /*
     * 명령 쿼리 원칙을 따르지 않음.
     * score 요청을 별도의 인터페이스로 분리하는 것은 어떨지?
     */
    public void calculate(Map<Attendance, Integer> attendanceStatus) {
        for (Attendance attendance : attendanceStatus.keySet()) {
            RuleItem ruleItem = ruleItemFactory.createRuleItem(attendance);
            
            score += ruleItem.score(attendanceStatus.get(attendance));
            absence -= ruleItem.absence(attendanceStatus.get(attendance));
        }
    }

    public int getScore() {
        if (absence > ALLOWED_ABSENCE_COUNT) {
            return 0;
        }

        return score; 
    }
}
