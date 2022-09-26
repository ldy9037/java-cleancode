package domain.attendance_v2;

public class Attendance implements Type{    
    public static final char TYPE = 'A';

    @Override
    public int score() {
        return 1;
    }
}
