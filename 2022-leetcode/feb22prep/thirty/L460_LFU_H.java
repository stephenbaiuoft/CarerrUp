package feb22prep.thirty;

import java.util.*;

public class L460_LFU_H {
    /**
     * Cache -> 存储integer integer
     * countMap 来存储 count 以及相对应的LinkedHashSet<> 这是存储 Entry用的
     */
    class LFUCache {
        private final int capacity;
        private HashMap<Integer, Entry> cache;
        private HashMap<Integer, LinkedHashSet<Entry>> countMap;
        private int min;


        // 其实注意maintain 这些structure就行了
        private class Entry{
            public int key;
            public int val;
            public int count;

            public Entry(int key, int val, int count){
                this.key = key;
                this.val = val;
                this.count = count;
            }
        }

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.countMap = new HashMap<>();
            this.min = -1; // Stores the value of the lowest count list
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;

            Entry e = cache.get(key);

            // Remove from the current list
            countMap.get(e.count).remove(e);

            if(min == e.count && countMap.get(e.count).size() == 0){
                countMap.remove(e.count);
                min++;
            }

            // Increment the count and put the entry in the required linkedhashset
            e.count++;
            if(countMap.containsKey(e.count) == false){
                countMap.put(e.count, new LinkedHashSet<>());
            }
            countMap.get(e.count).add(e);

            return e.val;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;

            if(cache.containsKey(key)){
                cache.get(key).val = value; // Update the value
                get(key); // Update the place of the key in the countMap
                return;
            }

            // Remove a key if we have reached the capacity of the cache
            if(cache.size() == capacity){
                removeLeastFrequentlyUsed();
            }

            // Add new entry to the cache
            Entry newEn = new Entry(key, value, 1);
            cache.put(key, newEn);

            if(!countMap.containsKey(1)){
                countMap.put(1, new LinkedHashSet<>());
            }
            countMap.get(1).add(newEn);
            min = 1;
        }

        private void removeLeastFrequentlyUsed(){
            Iterator<Entry> it = countMap.get(min).iterator();
            Entry e = it.next();

            it.remove();
            cache.remove(e.key);

            if(!it.hasNext()) countMap.remove(min);
        }

    }

}
