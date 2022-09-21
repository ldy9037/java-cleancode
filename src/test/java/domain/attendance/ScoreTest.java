package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {
    @Test
    @DisplayName("학생 번호를 반환한다.")
    void number() {
        // given
        int number = 1;

        // when 
        Score score = new Score(number, 10);

        // then 
        assertThat(score.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"10:2:8", "4:4:0", "2:5:-3"}, delimiter = ':')
    @DisplayName("두 객체를 score 기준으로 비교한다.")
    void compare(int score1, int score2, int expected) {
        // when 
        Score scoreObject1 = new Score(0, score1);
        Score scoreObject2 = new Score(1, score2);
        
        // then
        assertThat(scoreObject1.compareTo(scoreObject2)).isEqualTo(expected);
    }
}
