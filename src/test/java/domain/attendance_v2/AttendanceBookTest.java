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
    @DisplayName("결석 횟수가 최대 허용 값을 초과하면 0점 처리한다.")
    void getScoreWithMaxiumAbsence() {
        // given 
        String absence = generateAttendances("P", AttendanceBook.MAX_ALLOW_ABSENCE + 1);
        String attendance = generateAttendances("A", AttendanceBook.MAX_ALLOW_ABSENCE + 2);
        String[] attendances = {absence + attendance};

        // when 
        AttendanceBook attendanceBook = AttendanceBook.of(attendances);

        // then 
        assertThat(attendanceBook.getScore(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("점수가 음수가 될 경우 0점으로 처리한다.")
    void getMinusScore() {
        // given 
        String[] attendances = {"P"};
        
        // when
        AttendanceBook attendanceBook = AttendanceBook.of(attendances);
        
        // given 
        assertThat(attendanceBook.getScore(0)).isEqualTo(0);
    }

    private String generateAttendances(String type, int count) {
        return Stream.generate(() -> type).limit(count)
                                    .reduce((a, b) -> a + b)
                                    .get();
    }

}
