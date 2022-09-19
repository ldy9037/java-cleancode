package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttendanceTest {

    @Test
    @DisplayName("출석을 기록한다.")
    void create() {
        // given 
        char typeName = 'A';

        // when
        Attendance attendance = new Attendance(typeName);

        // then 
        assertThat(attendance.getType()).isEqualTo(typeName);
    }

    @Test
    @DisplayName("출석을 잘못 기입할 경우 에러가 발생한다.")
    void createWithNotExistType() {
        // given
        char typeName = 'D';

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                    .isThrownBy(() -> new Attendance(typeName))
                                    .withMessageMatching("출석 유형은 A,L,P 중 하나여야 합니다.");
    }

}
