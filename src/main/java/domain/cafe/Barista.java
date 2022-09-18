package domain.cafe;

public class Barista {
    public static Coffee createCoffee(MenuItem menuItem) {
        return new Coffee(menuItem);
    }
}
