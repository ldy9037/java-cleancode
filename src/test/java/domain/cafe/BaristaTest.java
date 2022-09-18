package domain.cafe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaristaTest {
    
    @Test
    @DisplayName("커피를 제조한다.")
    void createCoffee() {
        // given
        String menuName = "americano";
        
        // when
        Coffee coffee = Barista.createCoffee(new MenuItem("americano"));

        // then
        assertTrue(coffee.getName() == menuName);
    }

}
