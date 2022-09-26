package domain.attendance_v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class AttendacnesTest {
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"AAA:3", "APA:1"}, delimiter = ':')
    @DisplayName("점수를 계산한다.")
    void calculate(String history, int expected) {
        // when
        Attendances attendances = new Attendances(new AttendanceFactory());
        
        // then
        assertThat(attendances.calculate(history)).isEqualTo(expected);
    }
}
