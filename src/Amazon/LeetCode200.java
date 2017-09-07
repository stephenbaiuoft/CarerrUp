package Amazon;

/**
 * Created by stephen on 7/19/17.
 */

/*
*
*
*
        LeetCode200 program = new LeetCode200();
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        program.numIslands(grid);
*
*
* */
public class LeetCode200 {
    private int islandCount;

    public int numIslands(char[][] grid) {
        islandCount = 0;
        if(grid == null) return islandCount;

        for(int row =0; row < grid.length; row++){
            for(int column =0; column < grid[0].length; column++){
                if(grid[row][column] == '1'){
                    this.islandCount += 1;
                    getIsland(row, column, grid);
                }

            }
        }
        System.out.println(this.islandCount);
        return this.islandCount;
    }

    // modifies grid
    public void getIsland(int row, int column, char[][]grid) {
        if (row < grid.length && row > -1
                && column < grid[0].length && column > -1
                )
        {
            if (grid[row][column] == '1') {
                // v for visited
                grid[row][column] = 'v';

                getIsland(row - 1, column, grid);
                getIsland(row + 1, column, grid);
                getIsland( row, column - 1, grid);
                getIsland( row, column + 1, grid);
            }

        }
    }

}
