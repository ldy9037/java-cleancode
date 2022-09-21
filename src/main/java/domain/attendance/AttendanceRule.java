package domain.attendance;

import java.util.Map;

/**
 * 원시 타입이 포장되지 않음. 
 * 점수 자체를 의미하는 객체가 필요하지 않은지? 
 * AttendanceRule이 너무 많은 책임을 가지고 있는 것은 아닌지?
 * Score 객체와 AttendanceRule간의 책임을 명확히 할 필요 있음. 
 */
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
