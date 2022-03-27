package dp;

import java.util.HashMap;

/*
*
* Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.



Example 1:

Input: grid =
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].


Example 2:

Input: grid =
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.

* */

// 思路： 长方形--> 每多一条边， 那么你知道多的边可以作为新的base 从而增加/可以构建 之前所有的边数量的新的长方形
// 所以重要的是        ===> hashmap 来存 边的数量 就很重要了！！！！
public class L750_NumberOfCornerRectangles_M {

    // hValue + HashMap idea! 很重要
    public int countCornerRectangles(int[][] grid) {
        // sanity check

        // vars:
        // 1. for sum up total

        // loop through each row, and each time, you compute
        // hashMap to store compute(x1,x2), count of ocurrences

        if (grid == null || grid.length == 0) {
            return 0;
        }

        // map存的是 这个平行的 [(x1, x2), count] 现在有几条边
        // 那么每多一个base 就多了 count个长方形
        // 同时 ---------------> 新的边的数量为 count+1
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int curCount = 0;

        // loop through each row
        for(int[] row: grid) {
            // inner 2 loops to find (1,...1) pair
            for (int c1 = 0; c1 < row.length; c1++) {
                for (int c2 = c1+1; c2 < row.length; c2++) {
                    // find the 1 pair
                    if (row[c1] == 1 && row[c2] == 1) {
                        int hValue = c1 * 200 + c2; // 200 because of the length limit, [0,199] so safe to use 200
                        curCount = map.getOrDefault(hValue, 0);
                        // 因为是+= 所以之前的 已经在里面了
                        sum += curCount;
                        // update map
                        map.put(hValue, curCount + 1);
                    }
                }
            }
        }

        return sum;
    }
}
