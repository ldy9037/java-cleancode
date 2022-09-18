package domain.cafe;

public class Coffee {
    private final MenuItem menuItem;

    Coffee(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getName() {
        return menuItem.getName();
    }
}
