package domain.attendance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RuleItemTest {
    
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"A:10:10", "L:10:0", "P:10:-10"}, delimiter = ':')
    @DisplayName("출석 유형별 점수를 반환한다.")
    void score(char typeName, int count, int expected) {
        // when 
        RuleItemFactory ruleItemFactory = new RuleItemFactory();
        RuleItem ruleItem = ruleItemFactory.createRuleItem(new Attendance(typeName));
        int score = ruleItem.score(count);

        // then
        assertThat(score).isEqualTo(expected);
    }
}
