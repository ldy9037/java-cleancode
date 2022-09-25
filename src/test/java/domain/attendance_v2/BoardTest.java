package domain.attendance_v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BoardTest {
    
    @Test
    @DisplayName("순위를 확인한다.")
    void getRanking() {
        // given
        String[] attendances = {"A", "AAA", "AA"};
        AttendanceBook attendanceBook = AttendanceBook.of(attendances);

        // when 
        Board board = new Board(attendanceBook);

        // then
        assertThat(board.ranking()).containsExactly(2,3,1);
    }

}
