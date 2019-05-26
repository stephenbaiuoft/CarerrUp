package Codebase.SortAlgo;

import java.util.*;

public class L912_BestMeetingPoint_H {
    public int minTotalDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid[0].length < 1) return 0;
        List<Integer> xSet = new ArrayList<>();
        List<Integer> ySet = new ArrayList<>();
        for (int i = 0; i < grid.length;i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // marking the map position
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        return getShortestDistance(xSet) + getShortestDistance(ySet);
    }

    private int getShortestDistance(List<Integer> l) {
        Collections.sort(l);
        int i = 0;
        int j = l.size()-1;
        int sum = 0;
        while (i < j) {
            sum += l.get(j) - l.get(i); // for each i, j pair, you need to travel this much distance
            i++;
            j--; // when i==j, this is the median and 0 is required for these ppl
        }

        return sum;
    }

    public static long solution(long[][] clients) {
        // Type your solution here
        if (clients == null || clients.length == 0) return 0L;

        List<Long> xSet = new ArrayList<>();
        List<Long> ySet = new ArrayList<>();

        for (long[] client: clients) {
            xSet.add(client[0]);
            ySet.add(client[1]);
        }

        return getMinD(xSet) + getMinD(ySet);

    }

    private static long getMinD(List<Long> list) {
        Collections.sort(list);
        int left = 0;
        int right = list.size()-1;
        long sum = 0;

        while (left < right) {
            sum += list.get(right) - list.get(left);
            left ++;
            right--;
        }

        return sum;
    }
}
