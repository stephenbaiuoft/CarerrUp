package Amazon.OA2Review;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */

/**
 * DP: create a grid that records the minimum value up to the grid[i][j]
 *  value[i][j] = grid[i][j] + min{ value[i-1][j], value[i][j-1]}
 *
 *   Gonna use topdown approach: memoization
 */


public class L64_MinPathSum_M {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] valueGird = new int[grid.length][grid[0].length];
        valueGird[0][0] = grid[0][0] + 1;

        int min = fillValueGrid(valueGird, grid, grid.length - 1, grid[0].length - 1);
        return min - 1;
    }

    private int fillValueGrid(int[][] valueGrid, int[][] grid, int i, int j) {
        if(valueGrid[i][j] == 0) {
            if (i == 0) {
                valueGrid[i][j] = grid[i][j] + fillValueGrid(valueGrid, grid, i , j - 1);
                return valueGrid[i][j];
            }  else if (j == 0) {
                valueGrid[i][j] = grid[i][j] +  fillValueGrid(valueGrid, grid, i - 1, j );
                return valueGrid[i][j];
            }

            else {
                valueGrid[i][j] = grid[i][j]
                        + Math.min(fillValueGrid(valueGrid, grid, i - 1, j ),
                        (fillValueGrid(valueGrid, grid, i, j - 1 )));
                return valueGrid[i][j];
            }

        } else {
            return valueGrid[i][j];
        }
    }
}
