package domain.attendance;

public class RuleItemLate implements RuleItem{
    @Override
    public int score(int count) {
        return 0;
    }

    @Override
    public int absence(int count) {
        return count / 3;
    }
}
