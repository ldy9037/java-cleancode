package domain.attendance;

public class Score implements Comparable<Score>{
    private final int number;
    private final int score;

    Score(int number, int score) {
        this.number = number;
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }
}
