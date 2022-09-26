package domain.attendance_v2;

public class Late implements Type{
    public static final char TYPE = 'L';

    @Override
    public int score() {
        return 0;
    }
}
