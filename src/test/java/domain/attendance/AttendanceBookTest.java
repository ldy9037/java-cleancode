package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class AttendanceBookTest {
    
    @Test
    @DisplayName("출석 점수 순으로 학생 번호를 반환한다.")
    void ranking() {
        // given 
        String[] AttendancesArr = {"ALALALALPA", "AAAAAAAAPP", "LALLPALLPL"};

        // when 
        AttendanceBook attendanceBook = AttendanceBook.of(AttendancesArr);
        List<Integer> ranking = attendanceBook.ranking();
        
        // then
        assertThat(ranking).containsExactly(1, 0, 2);
    }
}
