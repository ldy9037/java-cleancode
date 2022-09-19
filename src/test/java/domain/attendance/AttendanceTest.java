package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttendanceTest {

    @Test
    @DisplayName("출석을 기록한다.")
    void createAttendance() {
        // given 
        char typeName = 'A';

        // when
        Attendance attendance = new Attendance(typeName);

        // then 
        assertThat(attendance.getType()).isEqualTo(typeName);
    }

}
