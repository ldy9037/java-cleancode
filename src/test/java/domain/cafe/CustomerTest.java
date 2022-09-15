package domain.cafe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomerTest {
    @Test
    @DisplayName("커피를 주문한다.")
    void order() {
        // given
        Menu menu = new Menu();
        String menuName = "americano";

        // when
        Customer customer = new Customer();

        // then
        assertTrue(customer.order(menu, menuName) instanceof Coffee);
    }
}
