package sorting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/*
*
Given a testing.string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"Tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

* */

/*
* https://leetcode.com/problems/sort-characters-by-frequency/description/
* 思路: top-k frequent element 也可以 或者 bucketsort 就是o(Const)的一个sort 顺序
* */

public class L451_SortCharByFreq {
    public L451_SortCharByFreq() {

    }

    public String frequencySortTopK(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        if (s == null || s.length() < 1) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // bucket sort!
        LinkedList<Character> [] bucket = new LinkedList[s.length() + 1];

        for (Map.Entry<Character, Integer> e: map.entrySet()) {
            int count = e.getValue();

            if (bucket[count] == null) {
                bucket[count] = new LinkedList<>();
            }
            bucket[count].add(e.getKey());
        }

        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null){
                while (!bucket[i].isEmpty()) {
                    char c = bucket[i].poll();
                    int copyCount = i;
                    while (copyCount > 0) {
                        sb.append(c);
                        copyCount --;
                    }
                }
            }
        }

        return sb.toString();
    }
}
