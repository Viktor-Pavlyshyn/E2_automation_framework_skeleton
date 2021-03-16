package patterns.core.iterator.menu;

import patterns.core.iterator.Menu;
import patterns.core.iterator.customiterator.PancakeHouseMenuIterator;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {
    List<String> menuItems;

    public PancakeHouseMenu(List<String> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Iterator<String> createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
