package Prep;

import java.util.*;

public class L692_TopKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        // base condition
        // null or k is not valid number
        if (words == null || words.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        // variables
        ArrayList<String> rez = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        // w1, w2, ... wn where count of w1>=w2
        PriorityQueue<String> pq = new PriorityQueue<String>(
                (String w1, String w2) -> {
                    if (map.get(w1) == map.get(w2)) {
                        return w1.compareTo(w2);
                    }
                    return map.get(w2) - map.get(w1);
        }


        );

        // hashmap to compute word, with each count number
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        // add to pq
        for (String word: map.keySet()) {
            pq.offer(word);
        }

        // so now you only count k times
        while (k > 0) {
            rez.add(pq.poll());
            k--;
        }

        // return the list of words for the given priority queue
        return rez;
    }
}
