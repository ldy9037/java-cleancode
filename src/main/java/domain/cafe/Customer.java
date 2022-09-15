package domain.cafe;

public class Customer {
    public Coffee order(Menu menu, String menuName) {
        return Barista.createCoffee(menu.getMenuItem(menuName));  
    }
}
