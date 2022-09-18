package domain.attendance;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class AttendanceBookTest {
    
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"AAALLLAPAA:A:6", "AAAAAAAPPP:P:3", "ALAAAAPAAA:L:1"}, delimiter = ':')
    @DisplayName("출석 유형별 횟수를 반환한다.")
    void getCountByAttendanceType(String history, char type, int expected){
        // when
        AttendanceBook attendanceBook = AttendanceBook.of(history);
        int count = attendanceBook.getCountByAttendanceType(type);

        // then
        assertThat(count).isEqualTo(expected);
    }
    
}
