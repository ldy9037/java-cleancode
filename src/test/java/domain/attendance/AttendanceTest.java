package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AttendanceTest {

    @Test
    @DisplayName("출석을 기록한다.")
    void createAttendance() {
        // when
        Attendance attendance = new Attendance(AttendanceType.ATTENDANCE);

        // then 
        assertThat(attendance.getType()).isEqualTo(type);
    }
}
