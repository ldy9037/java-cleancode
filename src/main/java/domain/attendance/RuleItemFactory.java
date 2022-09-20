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
        }

        return null;
    }
}
