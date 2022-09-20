package domain.attendance;

public class RuleItemFactory {
    public RuleItem createRuleItem(Attendance attendance) {
        switch (attendance.getType()) {
            case 'A':
                return new RuleItemAttendance();
            case 'L':
                return new RuleItemLate();
            case 'P':
                return new RuleItemAbsence();
            default :
                throw new IllegalArgumentException("A, L, P 출석 유형만 규칙이 존재합니다."); 
        }
    }
}
