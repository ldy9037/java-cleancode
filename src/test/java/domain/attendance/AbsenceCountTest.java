package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AbsenceCountTest {
    
    @Test
    @DisplayName("지각 횟수를 반환한다.")
    void getCount() {
        // given
        int count = 5;

        // when
        AbsenceCount absenceCount = new AbsenceCount(count);

        // then
        assertThat(absenceCount.getCount()).isEqualTo(count);
    }

    @Test
    @DisplayName("0 이상의 정수가 아니면 에러를 반환한다.")
    void createWithWrongRangeCount() {
        // given 
        int wrongRangeCount = -3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> new AbsenceCount(wrongRangeCount))
                                .withMessage("지각 횟수는 0 이상의 정수만 지정할 수 있습니다.");
    }

    @Test
    @DisplayName("지각 횟수를 추가한다.")
    void addCount() {
        // given 
        int initialCount = 3;
        int addCount = 5;

        // when
        AbsenceCount absenceCount = new AbsenceCount(initialCount);
        absenceCount.addCount(addCount);

        // then
        assertThat(absenceCount.getCount()).isEqualTo(initialCount + addCount);
    }

}
