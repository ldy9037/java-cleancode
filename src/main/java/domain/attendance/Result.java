package domain.attendance;

public class Result {

    public static int ALLOWED_ABSENCE_COUNT = 3;
    
    private final ScoreCount score;
    private final Absence absence;

    Result(ScoreCount score, Absence absence) {
        this.score = score;
        this.absence = absence;
    }

    public int getScore() {
        if (isExceededAbsences()) {
            return 0;
        }
        
        return score.getCount();
    }

    private boolean isExceededAbsences() {
        return (absence.getCount() > ALLOWED_ABSENCE_COUNT);
    }

}
