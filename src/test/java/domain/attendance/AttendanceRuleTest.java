package domain.attendance;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AttendanceRuleTest {
    
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"ALALALALPA:4", "AAAAAAAAPP:6", "LALLPALLPL:0"}, delimiter = ':')
    @DisplayName("점수를 계산한다.")
    void calculation(String attendances, int expected) {
        // when 
        AttendanceRule attendanceRule = new AttendanceRule();
        int score = attendanceRule.calculate(Attendances.of(attendances).getStatus());

        // then
        assertThat(score).isEqualTo(expected);
    }

}
