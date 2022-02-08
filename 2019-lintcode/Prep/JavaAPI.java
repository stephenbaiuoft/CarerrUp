package Prep;

import java.util.*;

public class JavaAPI {

    private void collectionSort() {
        int[][] intervals = new int[3][3];
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // the smaller ending time
            } else {
                return a[0] - b[0];
            }
        });
        // Collections.sort(intervals, (a,b) -> (a[1]-b[1]));
    }

    private void mapSort() {
        List<String[]> input = new ArrayList<>();
        input.add(new String[] {"r1","s1","msg"});
        int n = 3;

        Map<String, Integer> map = new HashMap<>();

        // minQueue
        PriorityQueue<String> q  =new PriorityQueue<>(
                (s1,s2)->(map.get(s1) - map.get(s2))
        );

        for (Map.Entry<String,Integer> e: map.entrySet()) {
            q.add(e.getKey());
            if (q.size() > n) {
                q.poll(); //remove the smallest count
            }
        }

        List<String> top = new ArrayList<>(q);
    }
}
