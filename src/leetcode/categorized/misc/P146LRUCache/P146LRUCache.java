package leetcode.categorized.misc.P146LRUCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class P146LRUCache {
    LinkedHashMap<Integer, Integer> keyval;
    int capacity;

    public P146LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyval = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (keyval.size() == 0 || !keyval.containsKey(key)) return -1;

        int value = keyval.get(key);
        keyval.remove(key);
        keyval.put(key, value);

        return value;
    }

    public void put(int key, int value) {
        if (keyval.containsKey(key)) {
            keyval.remove(key);
        } else if (keyval.size() == this.capacity) {
            Set<Map.Entry<Integer, Integer>> mapEntries = keyval.entrySet();
            Iterator<Map.Entry<Integer, Integer>> itr = mapEntries.iterator();
            int firstKey = itr.next().getKey();
            keyval.remove(firstKey);
        }
        keyval.put(key, value);

    }
}