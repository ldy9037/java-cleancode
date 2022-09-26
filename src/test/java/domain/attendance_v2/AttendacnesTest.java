package domain.attendance_v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

public class AttendacnesTest {

    private Attendances attendances;

    @BeforeEach
    void setUp() {
        this.attendances = new Attendances(new AttendanceFactory());
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"AAA:3", "APA:1"}, delimiter = ':')
    @DisplayName("점수를 계산한다.")
    void calculate(String history, int expected) {
        // when
        int score = attendances.calculate(history);

        // then
        assertThat(score).isEqualTo(expected);
    }

    @Test
    @DisplayName("결석 횟수가 최대 허용 값을 초과하면 0점 처리한다.")
    void getScoreWithMaxiumAbsence() {
        // given 
        String absence = generateAttendances("P", Attendances.MAX_ALLOW_CAUTION + 1);
        String attendance = generateAttendances("A", Attendances.MAX_ALLOW_CAUTION + 2);

        // when 
        int score = attendances.calculate(absence + attendance);

        // then 
        assertThat(score).isEqualTo(0);
    }

    private String generateAttendances(String type, int count) {
        return Stream.generate(() -> type).limit(count)
                                    .reduce((a, b) -> a + b)
                                    .get();
    }
}
