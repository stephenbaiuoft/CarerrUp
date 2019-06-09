package DFS;

public class L815_CourseScheduleIV {
    private boolean[][] pre = null;
    private int[] preCnt = null;
    boolean[] selectedCourse = null;
    int total = 0;
    int n = 0;

    public int topologicalSortNumber(int n, int[][] p) {
        // Write your code here
        this.n = n;
        this.pre = new boolean[n][n]; // build nxn matrix
        this.preCnt = new int[n];
        this.selectedCourse = new boolean[n];

        int c1, c2 = 0;
        for (int[] pre: p) {
            c2 = pre[0];
            c1 = pre[1];
            this.pre[c1][c2] = true;
            this.preCnt[c2]++; // dependencies for c2 increment by 1
        }

        dfs(0);
        return total;
    }

    // level --> 第几层 每一层的dependency在这个时候 都应该是0
    private void dfs(int level) {
        if (level == this.n) {
            this.total++;
            return;
        }

        // again explore all courses every recursion
        for (int i = 0; i < this.n; i++) {
            if (!this.selectedCourse[i] && preCnt[i] == 0) {
                this.selectedCourse[i] = true;
                for (int j = 0; j < n; j++) {
                    if (pre[i][j]) {
                        preCnt[j]--;
                    }
                }

                dfs(level + 1);

                // restore
                for (int j = 0; j < n; j++) {
                    if (pre[i][j]) {
                        preCnt[j]++;
                    }
                }
                selectedCourse[i] = false;
            }

        }
    }
}
