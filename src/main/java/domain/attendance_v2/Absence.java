package domain.attendance_v2;

public class Absence implements Type{
    public static final char TYPE = 'P';

    @Override
    public int score() {
        return -1;
    }
}
