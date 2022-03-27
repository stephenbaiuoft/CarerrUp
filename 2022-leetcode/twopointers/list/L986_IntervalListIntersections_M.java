package twopointers.list;

import java.util.*;


// https://leetcode.com/problems/interval-list-intersections/submissions/
public class L986_IntervalListIntersections_M {
    // 思路 overlap + 2 pointer
    // maxStartPoint <= minEndpoint 重点
    // 其次 如何advance i, j pointer
    // 因为知道 per list不会overlap 所以每次可以advance最小的那个endpoint 因为下个overlap只能在它这里

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // i && j to first and second
        // max(startIndex) for first and second
        // max(endIndex) for first and second
        int i = 0, j = 0;
        int n1 = firstList.length;
        int n2 = secondList.length;
        List<int[]> answer = new LinkedList<>();
        int maxStart = 0;
        int minEnd = 0;

        while (i < n1 && j < n2) {
            int[] f = firstList[i];
            int[] s = secondList[j];

            // check overlap?
            // maxStart <= minEnd
            maxStart = Math.max(f[0], s[0]);
            minEnd = Math.min(f[1], s[1]);
            if (maxStart <= minEnd) {
                answer.add(new int[]{maxStart, minEnd});
            }
            // how to advance
            if (f[1] < s[1]) {
                i+=1;
            } else {
                j+=1;
            }
        }

        int[][] ans = new int[answer.size()][2];
        for (i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }


}
