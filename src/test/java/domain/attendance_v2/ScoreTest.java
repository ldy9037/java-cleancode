package domain.attendance_v2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {
    
    @Test
    @DisplayName("점수를 생성한다.")
    void create() {
        // given 
        int sampleScore = 1000;

        // when 
        Score score = new Score(sampleScore);

        // then 
        assertThat(score).isEqualTo(new Score(sampleScore));
    }

    @Test
    @DisplayName("점수를 더한다.")
    void add() {
        // given 
        int moreScore = 10;
        
        // when
        Score score = new Score(moreScore);
        score.add(moreScore);

        // then
        assertThat(score.getScore()).isEqualTo(moreScore * 2);
    }

    @Test
    @DisplayName("점수 인자가 음수일 경우 에러를 반환한다.")
    void addWithMinusScore() {
        // given
        int minusScore = -10;
        Score score = new Score(0);
        
        // when 
        assertThatExceptionOfType(IllegalArgumentException.class)
                                .isThrownBy(() -> score.add(minusScore))
                                .withMessage("점수는 양수로 입력해주세요.");
    }
    
}
