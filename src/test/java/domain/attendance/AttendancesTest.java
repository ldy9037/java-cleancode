package domain.attendance;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class AttendancesTest {
    
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"ALALALALPA:5:4:1", "AAAAAAAAPP:8:0:2", "LALLPALLPL:2:6:2"}, delimiter = ':')
    @DisplayName("타입별 출석 수를 반환한다.")
    void getStatus(String attendances, int aTypeCount, int lTypeCount, int pTypeCount) {
        // when
        int[] expected = {aTypeCount, lTypeCount, pTypeCount};
        Map<Attendance, Integer> status = Attendances.of(attendances).getStatus();

        // then
        for (int i = 0; i < Attendance.TYPES.length; i++) {
            assertThat(status.get(new Attendance(Attendance.TYPES[i]))).isEqualTo(expected[i]);           
        }
    }

}
