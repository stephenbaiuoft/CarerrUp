package hashmap_questions;


/*
Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.



Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4
Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2

*
*
* 思路
*
* hashmap来存 Y-axis的pair 根据 y0, y1, ... yn ==> (y0,y1) (y0,y2), and etc ..... (yn-1, yn) ==》 total of O(n^2) pairs
* */

import java.util.*;

public class L939_MinimumAreaRectangle_M {
    public int minAreaRect(int[][] points) {
        // Comparator<int[]> c = Comparator.comparingInt((int[] element) -> element[0]);
        // comparing but 2 attributes
        Arrays.sort(points, Comparator.comparingInt((int[] e) -> e[0]).thenComparing( (int[] e) -> e[1]));

        if (points == null || points[0].length == 0) return 0;
        // variables, need to store each cordinate xi, with y cordinates for each xi
        LinkedHashMap<Integer, ArrayList<Integer>> xMap = new LinkedHashMap<>();
        for (int[] point: points) {
            xMap.computeIfAbsent(point[0], v-> new ArrayList<>()).add(point[1]);
        }

        HashMap<Integer, Integer> yPairsToX = new HashMap<>();
        int minArea = Integer.MAX_VALUE;
        // iterate through, with x-axis incrementing gradually
        for (Map.Entry<Integer, ArrayList<Integer>> entry: xMap.entrySet()) {
            int x = entry.getKey();
            ArrayList<Integer> yCordinates = entry.getValue();
            Collections.sort(yCordinates);

            for (int i = 0; i < yCordinates.size(); i++ ) {
                for (int j = i+1; j < yCordinates.size(); j++) {
                    int y1 = yCordinates.get(i);
                    int y2 = yCordinates.get(j);

                    int v = 40001 * y1 + y2;
                    // if the x does have this pair as well
                    if (yPairsToX.containsKey(v)) {
                        minArea = Math.min(minArea,
                                (y2 - y1)*(x- yPairsToX.get(v))
                                );
                    }
                    // update to map to use the closer x now
                    yPairsToX.put(v, x);
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0: minArea;
    }
}
