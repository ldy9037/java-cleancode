package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(ints = {4, 10, 3})
    @DisplayName("최소 지각 횟수를 초과할 경우 0점을 반환한다.")
    void getScoreWithOverAbsenceCount(int score) {
        // when 
        Result result = new Result(
                            new ScoreCount(score), 
                            new Absence(Result.ALLOWED_ABSENCE_COUNT + 1));

        assertThat(result.getScore()).isEqualTo(0);
    }
}
