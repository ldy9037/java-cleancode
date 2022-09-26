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
    
}
