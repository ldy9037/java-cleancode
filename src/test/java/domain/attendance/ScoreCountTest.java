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

}
