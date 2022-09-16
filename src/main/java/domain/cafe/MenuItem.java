package domain.cafe;

public class MenuItem {
    private final String menuName;

    MenuItem(String menuName) {
        this.menuName = menuName;
    }        
    
    public String getName() {
        return menuName;
    }
}
