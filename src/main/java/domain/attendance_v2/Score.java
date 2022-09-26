package domain.attendance_v2;

import java.util.Objects;

public class Score {
    public static final int ZERO = 0;
    
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void add(int score) {
        validate(score);
        this.score += score;
    }

    private void validate(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("점수는 양수로 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Score)) return false;

        Score that = (Score) obj;
        
        return (score == that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
