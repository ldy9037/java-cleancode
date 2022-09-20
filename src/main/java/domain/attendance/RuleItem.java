package domain.attendance;

public interface RuleItem {
    public int score(int count);
    public int absence(int count);
}
