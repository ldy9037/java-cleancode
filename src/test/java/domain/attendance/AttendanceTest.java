package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttendanceTest {

    @Test
    @DisplayName("출석을 기록한다.")
    void createAttendance() {
        // given
        char type = 'A';

        // when
        Attendance attendance = new Attendance(type);

        // then 
        assertThat(attendance.getType()).isEqualTo(type);
    }

    @Test
    @DisplayName("출석부에 없는 유형의 출석타입을 기록할 경우 에러가 발생한다.")
    void createNotExistAttendance() {
        // given 
        char type = 'C';
        
        // when & then 
        assertThatExceptionOfType(IllegalArgumentException.class)
                                        .isThrownBy(() -> new Attendance(type))
                                        .withMessageMatching("출석 유형은 A, L, P 중 하나여야 합니다.");
    }

}
