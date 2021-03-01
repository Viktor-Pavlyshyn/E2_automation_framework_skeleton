package patterns.core.iterator.customiterator;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<String> {
    String[] items;
    int position = 0;

    public DinerMenuIterator(String[] items) {
        this.items = items;
    }

    @Override
    public String next() {
        int t = position;
        position++;
        return items[t];
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }
}
