package domain.attendance;

public class RuleItemAbsence implements RuleItem{
    @Override
    public int score(int count) {
        return -count;
    }

    @Override
    public int absence(int count) {
        return count;
    }
}
