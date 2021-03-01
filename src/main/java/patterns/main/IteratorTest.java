package patterns.main;

import patterns.core.Cafe;
import patterns.core.iterator.menu.DinerMenu;
import patterns.core.iterator.menu.PancakeHouseMenu;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        String[] pizzas = new String[]{"La Pizza – Derby", "Pizza Fella – Leeds", "The White Rabbit – Oxford"};
        List<String> beer = new ArrayList<>();
        beer.add("Staropramen");
        beer.add("Bud");
        beer.add("Stare Misto");

        Cafe cafe = new Cafe(new DinerMenu(pizzas), new PancakeHouseMenu(beer));

        cafe.printDinerMenu();
        cafe.printPancakeHouseMenu();
    }
}
