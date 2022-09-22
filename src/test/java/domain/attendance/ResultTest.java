package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"10:2:10", "8:0:8"}, delimiter = ':')
    @DisplayName("최종 점수를 반환한다.")
    void getScore(int score, int absence, int expected) {
        // when 
        Result result = new Result(new ScoreCount(score), new Absence(absence));

        // then
        assertThat(result.getScore()).isEqualTo(expected);
    }
}
