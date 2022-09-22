package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreCountTest {
    
    @Test
    @DisplayName("점수를 반환한다.")
    void getScore() {
        // given 
        int score = 5;

        // when
        ScoreCount scoreCount = new ScoreCount(score);

        // given
        assertThat(scoreCount.getCount()).isEqualTo(score);
    }

    @Test 
    @DisplayName("점수가 0점 미만이면 에러가 발생한다.")
    void createWithWrongRangeScore() {
        // given
        int wrongRangeScore = -3;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> new ScoreCount(wrongRangeScore))
                                .withMessage(String.format("점수는 0 이상의 정수로만 생성 가능합니다."));
    }
}
