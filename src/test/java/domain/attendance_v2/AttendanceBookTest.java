package domain.attendance_v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

public class AttendanceBookTest {

    @Test
    @DisplayName("출석 점수를 확인한다.")
    void getScore() {
        // given 
        String[] attendances = {"AALP", "A"};
        Integer[] expected = {1, 1};

        // when
        AttendanceBook attendanceBook = AttendanceBook.of(attendances);
    
        // then
        for (int i = 0; i < attendances.length; i++) {
            assertThat(attendanceBook.getScore(i)).isEqualTo(expected[i]);
        }
    }

    @Test
    @DisplayName("결석이 최소값 이상 포함되어 있으면 0점 처리한다.")
    void getScoreWithMaxiumAbsence() {
        // given 
        String absence = generateAttendances("P", AttendanceBook.MAX_ALLOW_ABSENCE);
        String attendance = generateAttendances("A", AttendanceBook.MAX_ALLOW_ABSENCE + 2);
        String[] attendances = {absence + attendance};

        // when 
        AttendanceBook attendanceBook = AttendanceBook.of(attendances);

        // then 
        assertThat(attendanceBook.getScore(0)).isEqualTo(0);
    }

    private String generateAttendances(String type, int count) {
        return Stream.generate(() -> type).limit(count)
                                    .reduce((a, b) -> a + b)
                                    .get();
    }

}
