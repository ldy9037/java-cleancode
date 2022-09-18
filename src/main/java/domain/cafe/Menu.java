package domain.cafe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private List<MenuItem> menuItemList;

    Menu(MenuItem... menuItemArr) {
        this.menuItemList = Stream.of(menuItemArr)
                             .collect(Collectors.toList());
    }

    public MenuItem getMenuItem(String menuName) {
        return selectMenu(menuName);
    }    

    private MenuItem selectMenu(String menuName) {
        for (MenuItem menuItem : menuItemList) {
            if (isSameName(menuItem, menuName)) {
                return menuItem;
            }
        }

        throw new NullPointerException("존재하지 않는 메뉴입니다.");
    }

    private boolean isSameName(MenuItem menuItem, String menuName) {
        return menuItem.getName().equals(menuName);
    }
    
}
