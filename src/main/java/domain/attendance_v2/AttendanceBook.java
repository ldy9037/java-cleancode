package domain.attendance_v2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttendanceBook {
    
    private final List<List<Character>> book;

    AttendanceBook(List<List<Character>> book) {
        this.book = book;
    }

    public static AttendanceBook of(String[] attendanceArr) {
        List<List<Character>> book = Stream.of(attendanceArr)
                                            .map(AttendanceBook::stringToCharacter)
                                            .collect(Collectors.toList());
        
        return new AttendanceBook(book);
    }

    private static List<Character> stringToCharacter(String str) {
        return str.chars()
                    .mapToObj(i -> (char)i)
                    .collect(Collectors.toList());
    }

    public int getScore(Integer id) {
        return calculate(book.get(id));
    }

    public int calculate(List<Character> attendances) {
        int score = 0;

        for (Character attendance : attendances) {
            if (attendance == 'A') {
                score += 1;
            }
            if (attendance == 'P') {
                score -= 1;
            }
        }
        
        return score;
    }
}
