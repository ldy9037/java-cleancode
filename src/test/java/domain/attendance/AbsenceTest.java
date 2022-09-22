package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AbsenceTest {
    
    @Test
    @DisplayName("지각 횟수를 반환한다.")
    void getCount() {
        // given
        int count = 5;

        // when
        Absence absence = new Absence(count);

        // then
        assertThat(absence.getCount()).isEqualTo(count);
    }

    @Test
    @DisplayName("지각이 0번 미만일 경우 에러가 발생한다.")
    void createWithWrongRangeCount() {
        // given 
        int wrongRangeCount = -3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> new Absence(wrongRangeCount))
                                .withMessage("지각 횟수는 0번 이상만 지정할 수 있습니다.");
    }
}
