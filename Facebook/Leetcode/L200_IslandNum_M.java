package Leetcode;

/**
 char[][] grid = new char[][] {
 {'1','1','1','1','0'},
 {'1','1','0','1','0'},
 {'1','1','0','0','0'},
 {'0','0','0','0','0'},
 {'0','0','0','0','0'},
 {'0','0','0','0','0'},
 {'0','0','0','0','0'}
 };
 L200_IslandNum_M p = new L200_IslandNum_M();
 System.out.println(p.numIslands(grid));
 *
 */

public class L200_IslandNum_M {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0 ){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char t = grid[i][j];
                boolean r = t == '1';

                if (grid[i][j] == '1' && !visited[i][j]) {
                    count +=1;
                    set(i, j, row, col, grid, visited);
                }
            }
        }
        System.out.print("did it run?");
        return count;
    }

    private void set(int i, int j, int row, int col,
                     char[][] grid, boolean[][] visited) {
        if (i < row && j < col) {
            if (grid[i][j] == '1') {
                visited[i][j] = true;
            }
            // iterate through
            set(i+1, j, row, col, grid, visited);
            set(i, j+1, row, col, grid, visited);
        }
    }


    public class Solution {
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
}
