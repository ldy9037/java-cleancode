package domain.attendance_v2;

import java.util.Arrays;
import java.util.List;

public class AttendanceBook {
    public static final int MAX_ALLOW_ABSENCE = 3;

    private final List<String> book;
    private final Attendances attendances = new Attendances(new AttendanceFactory());

    AttendanceBook(List<String> book) {
        this.book = book;
    }

    public static AttendanceBook of(String... attendanceArr) {
        List<String> book = Arrays.asList(attendanceArr);
        
        return new AttendanceBook(book);
    }

    public int count() {
        return book.size();
    }
    
    public int getScore(Integer id) {
        return attendances.calculate(book.get(id));
    }
}
