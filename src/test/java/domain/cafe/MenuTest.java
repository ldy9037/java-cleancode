package domain.cafe;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(
            new MenuItem("americano"),
            new MenuItem("latte"),
            new MenuItem("macchiato")
        );
    }
    
    @ParameterizedTest(name = "{displayName} - {arguments}")
    @ValueSource(strings = {"americano", "latte", "macchiato"})
    @DisplayName("메뉴를 제공한다.")
    public void getMenuItem(String menuName) {
        // when
        MenuItem menuItem = menu.getMenuItem(menuName);

        // then
        assertThat(menuItem.getName()).isEqualTo(menuName);
    }

    @Test
    @DisplayName("존재하지 않는 메뉴를 선택할 경우 에러가 발생한다.")
    public void getNotExistMenuItem() {
        // given 
        String menuName = "cappuccino";

        // when * then
        assertThatExceptionOfType(NullPointerException.class)
                                    .isThrownBy(() -> menu.getMenuItem(menuName))
                                    .withMessageMatching(ErrorMessage.NOT_EXIST_MENU_ERROR.getMessage());
    }
}