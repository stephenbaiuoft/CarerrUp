package Microsoft;

public class L174_dungeon_H {

    public void test() {
        int[][] test = { {0} };
        calculateMinimumHP(test);

        int a = 0;
        long b = new Long(10);
        if (a > b) {

        }
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return -1;

        }

        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] minHealth = new int[row][col];
        for(int i = row -1; i >=0; i--) {
            for(int j = col-1; j >=0; j--) {
                // base case
                if(j == col-1 && i == row-1) {
                    minHealth[i][j] = Math.max(1, 1- dungeon[i][j]);
                }
                // last row
                else if (i == row - 1) {
                    minHealth[i][j] = Math.max(1, minHealth[i][j+1] - dungeon[i][j]);
                }
                // last column
                else if (j == col - 1) {
                    minHealth[i][j] = Math.max(1, minHealth[i+1][j] - dungeon[i][j]);
                }

                else {
                    minHealth[i][j] = Math.max(1,
                            Math.min(minHealth[i+1][j], minHealth[i][j+1]) - dungeon[i][j]);
                }

            }
        }

        // starting position!!!
        return minHealth[0][0];
    }
}
