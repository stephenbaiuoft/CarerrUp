package sorting;

import java.util.*;

public class L347_TopKFreqElements_M {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 1. map to store value: nums[i], key: # of occurences for nums[i]
        // 2. we need to sort the map based on Map.Entry<Integer, Integer> e, where DESC by
        // e2.getValue() - e1.getValue()
        // 2.1 this can be done with a priorityqueue
        // 3. a list to store the end result, with while-loop to pop k elements only

        List<Integer> list = new LinkedList<>();

        if (nums == null || nums.length < 1 || k < 1) return list;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> c = ((a, b) -> (b.getValue() - a.getValue()));
        Comparator<Map.Entry<Integer, Integer>> cf = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return 0;
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(c);

        LinkedList<Integer> l = new LinkedList<>();
        // note l is sorted!
        Comparator<Integer> c1 = ((a, b) -> (b - a));
        Collections.sort(l, c1);


        q.addAll(map.entrySet());

        while (!q.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> e = q.poll();
            list.add(e.getKey());
            k--;
        }

        return list;

    }
}
