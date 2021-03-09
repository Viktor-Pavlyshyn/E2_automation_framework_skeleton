package patterns.core.iterator.customiterator;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator<String> {
    List<String> items;
    int position = 0;

    public PancakeHouseMenuIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public String next() {
        int t = position;
        position++;
        return items.get(t);
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }
}
