package hashmap.questions;

import java.util.HashMap;
import java.util.List;
/*
* https://leetcode.com/problems/brick-wall/description/
*
* There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers
 representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed.
You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall,
 in which case the line will obviously cross no bricks.

Example:
Input:
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2

* */

/*
* 纵向看width 然后 发现 从左边到右边
*  [1, 2, 2, 1] -> [1, 3, 5, 6]
*  [3, 1, 2] -> [3,4,6]
*  只要数一数相同的width有几个 而最大的数量 就意味着在这个width滑下去 穿过的brick最少
* */

public class L554_BrickWall_M {
    public int leastBricks(List<List<Integer>> wall) {
        // always check for base case
        if (wall == null || wall.size()  < 1 || wall.get(0).size() < 1) return 0;
        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < wall.size(); i++) {
            int curWidth = 0;
            for ( int j = 0; j < wall.get(i).size() - 1; j++) {
                curWidth += wall.get(i).get(j);
                map.put(curWidth, map.getOrDefault(curWidth, 0) + 1);


                maxCount = Math.max(maxCount, map.get(curWidth));

            }
        }

        // maxCount -> maximum # of slices together
        return wall.size() - maxCount;
    }

}
