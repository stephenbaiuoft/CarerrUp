package algorithm.related.sharding;

import java.util.*;

public class L519_SimpleHashing_E {
    // https://www.lintcode.com/problem/519/
    public List<List<Integer>> consistentHashing(int n) {
        // write your code here
        PriorityQueue<List<Integer>> answer = new PriorityQueue<>(
                Comparator.comparing((List<Integer> v) -> v.get(0) - v.get(1)).thenComparing
                        ((List<Integer> v) -> v.get(2))
        );
        answer.offer(Arrays.asList(0, 359, 1));
        for (int i = 2; i <= n; i++) {
            // get largest section
            List<Integer> select = answer.poll();
            int left = select.get(0);
            int right = select.get(1);
            int mid = left + (right - left)/2;

            answer.offer(Arrays.asList(
                    left, mid, select.get(2)
            ));

            answer.offer(Arrays.asList(
                    mid + 1, right, i
            ));

        }

        List<List<Integer>> ans = new ArrayList<>(answer);
        return ans;

    }
}
