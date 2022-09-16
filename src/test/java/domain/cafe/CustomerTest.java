package domain.cafe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomerTest {
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(strings = {"americano", "latte", "macchiato"})
    @DisplayName("커피를 주문한다.")
    void order(String menuName) {
        // given
        Customer customer = new Customer();

        // when
        Coffee coffee = customer.order(new Menu(), menuName);

        // then
        assertTrue(coffee instanceof Coffee);
    }
}
