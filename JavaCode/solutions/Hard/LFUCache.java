public class LFUCache {

    HashMap<Integer, Integer> vals; // key to val
    HashMap<Integer, Integer> counts; // key to count
    // count to list of keys
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap; // capacity of the cache
    int min = -1; // track the min value

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        // Can't find val for the key
        if (!vals.containsKey(key))
            return -1;
        // Update count of a key in count to key map
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        // If least frequent key is removed
        if (count == min && lists.get(count).size() == 0)
            min++;
        // Update key to list map
        if (!lists.containsKey(count + 1))
            lists.put(count + 1, new LinkedHashSet<>());
        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        // Update key to val map
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        // If is full remove the min
        // remove from lists and vals map
        if (vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        // Not in cache
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */