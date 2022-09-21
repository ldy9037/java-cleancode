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

}
