package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreCountTest {
    
    @Test
    @DisplayName("점수를 반환한다.")
    void getCount() {
        // given 
        int count = 5;

        // when
        ScoreCount scoreCount = new ScoreCount(count);

        // given
        assertThat(scoreCount.getCount()).isEqualTo(count);
    }

    @Test 
    @DisplayName("0 이상의 정수가 아니면 에러를 반환한다.")
    void createWithWrongRangeCount() {
        // given
        int wrongRangeCount = -3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> new ScoreCount(wrongRangeCount))
                                .withMessage(String.format("점수는 %s 이상이어야 합니다.", ScoreCount.MINIMUM_COUNT));
    }
}
