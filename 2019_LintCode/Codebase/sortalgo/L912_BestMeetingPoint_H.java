package Codebase.sortalgo;

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
}
