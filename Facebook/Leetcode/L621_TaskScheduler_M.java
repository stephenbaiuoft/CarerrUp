package Leetcode;

import java.util.HashMap;

// tasks = ["A","A","A","B","B","B"], n = 2
public class L621_TaskScheduler_M {
    public void test() {
        char[] input = new char []{'A','A','A','B','B','B'};
        leastInterval(input, 2);
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) return 0;
        int max_value = 0;
        int max_count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : tasks) {
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;

                // update max_count if necessary
                max_value = Math.max(count, max_value);
                map.put(c, count);
            } else{
                map.put(c, 1);
            }
        }
        // count # of max_values
        for (int v: map.values()) {
            if (v == max_value){
                max_count+=1;
            }
        }

        // -> # to fit character with max occurences

        int minRequired = (max_value -1 ) *(n+1) + max_count;


        if (minRequired < tasks.length){
            return tasks.length;
        }else{
            return minRequired;
        }
    }

}

