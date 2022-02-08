package ByMonth.august.March;

public class L463_IslandPerimeter_E {
    public int islandPerimeter(int[][] grid) {
        // idea: each '1' if seperate has 4 sides
        //       '1' joined with another '1' makes 2 sides disappear
        //  --> count # of 1
        //  --> count # of joined 1s, which would make 2 sides disappear
        // ==> 4 * num_1 - 2 * num_1_pair
        if (grid == null || grid.length == 0) return 0;
        int oneCount = 0;
        int onePairCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                if (grid[i][j] ==1) {
                    // increment the oneCount
                    oneCount++;
                    if(j < grid[0].length - 1 && grid[i][j+1] ==1) {
                        // increment the onePairCount (always to the right)
                        onePairCount++;
                    }
                    if(i < grid.length-1 && grid[i+1][j] ==1) {
                        onePairCount++;
                    }
                }

            }
        }

        return oneCount * 4 - onePairCount * 2;

    }
}
