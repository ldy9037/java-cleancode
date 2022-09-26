package domain.attendance_v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttendanceBookTest {

    @Test
    @DisplayName("학생 총 인원을 반환한다.")
    void count() {
        // given
        String[] attendances = {"PPAP", "AL", "APLAPL", "ALAA"};
        
        // when
        int studentCount = AttendanceBook.of(attendances).count();

        // then
        assertThat(studentCount).isEqualTo(attendances.length);
    }

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
}
