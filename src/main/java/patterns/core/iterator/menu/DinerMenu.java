package patterns.core.iterator.menu;

import patterns.core.iterator.Menu;

import patterns.core.iterator.customiterator.DinerMenuIterator;

import java.util.Iterator;

public class DinerMenu implements Menu {
    String[] menuItems;

    public DinerMenu(String[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Iterator<String> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
