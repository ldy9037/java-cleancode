package domain.attendance;

public class Result {
    
    private final ScoreCount score;
    private final Absence absence;

    Result(ScoreCount score, Absence absence) {
        this.score = score;
        this.absence = absence;
    }

    public int getScore() {
        return score.getCount();
    }

}
