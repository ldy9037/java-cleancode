package domain.cafe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(strings = {"americano", "latte", "macchiato"})
    @DisplayName("커피를 주문한다.")
    void order(String menuName) {
        // given
        Menu menu = new Menu();

        // when
        Customer customer = new Customer();

        // then
        assertTrue(customer.order(menu, menuName) instanceof Coffee);
    }
}
