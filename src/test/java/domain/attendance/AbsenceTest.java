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
    @DisplayName("지각 횟수로 최소값 미만의 정수를 전달하면 에러를 반환한다.")
    void createWithWrongRangeCount() {
        // given 
        int wrongRangeCount = -3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> new Absence(wrongRangeCount))
                                .withMessage(String.format("지각 횟수는 %d 이상의 정수만 지정할 수 있습니다.", Absence.MINIMUM_COUNT));
    }

    @Test
    @DisplayName("지각 횟수를 추가한다.")
    void addCount() {
        // given 
        int initialCount = 3;
        int addCount = 5;

        // when
        Absence absence = new Absence(initialCount);
        absence.addCount(addCount);

        // then
        assertThat(absence.getCount()).isEqualTo(initialCount + addCount);
    }

}
