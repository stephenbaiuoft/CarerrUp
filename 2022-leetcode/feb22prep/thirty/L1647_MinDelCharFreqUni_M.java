package feb22prep.thirty;
import java.util.*;

public class L1647_MinDelCharFreqUni_M {
    public int minDeletions(String s) {
        // charCount -> with each character && it's frequency
        // Now create a HashMap<countChar, #OfChar>
        // -> Then from s.length(), O(n), get of firstCount with #ofChar > 1,
        //  => Add distance, from firstCount, and update hashMap
        // return final result
        int[] charCount = new int[26];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // increment the char at that count
            charCount[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < 26; i++) {
            int count = charCount[i];
            if (count > 0) {
                // update # of occurences for that count by 1
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }

        // From high to low
        // O(n^2) in the worst case ???
        int total = 0;
        for (int c = s.length(); c > 0; c --) {
            // ensure the count exist
            if (map.get(c) != null && map.get(c) > 1) {
                int cValue = map.get(c);
                while (cValue > 1) {
                    // Update the map
                    cValue --;
                    total += getNextAvailable(map, c);
                }
                // only 1 at this point now
                map.put(c, 1);
            }

        }

        return total;
    }

    // get the next available and compute how many to decrease for the given start
    private int getNextAvailable(HashMap<Integer,Integer> map, int start) {
        int count = 0;
        boolean found = false ;
        while (start > 0 && !found) {
            start --;
            if (map.get(start) == null) {
                // update with 1
                map.put(start, 1);
                found = true; // break the while loop
            }
            count ++;
        }

        return count;
    }
}
