package dp;

// Characterize the structure of optimal solution (Define that optimal f)
// Recursively define the value of an optimal solution f(n) = some mathematics of f(n1), f(n2) and etc, where n1, n2 < n
// Compute the value of the optimal solution (Bottom up or Top down)

public class L70_ClimbingStairs_E {
    public int climbStairsBottomUp(int n) {
        int[] count = new int[n+1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = count[i-1] + count[i-2];
        }

        return count[n];

    }



    public int climbStairsTopDown(int n) {
        int[] count = new int[n+1];

        return getStairs(n, count);

    }

    public int getStairs(int n, int[] count) {
        if (n == 1) {

            return 1;
        } else if (n == 2) {

            return 2;
        } else {
            if (count[n] != 0) return count[n];
            count[n] = getStairs(n-1, count) + getStairs(n-2, count);
            return count[n];

        }

    }

}
