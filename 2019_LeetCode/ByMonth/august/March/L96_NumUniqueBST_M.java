package ByMonth.august.March;

// think of the # of left possible solutions * # of right possible solutions
// --> look @ the tree structure ==> you should understand!
public class L96_NumUniqueBST_M {


    public int numTrees(int n) {
        if(n <= 0) return 0;

        int[] dp = new int[n+1];
        // null is 1 way,  1 node is also 1 way
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <=n ; i ++) {
            // think of left as # of nodes to the left
            for(int left = 0; left < i; left ++) {
                // i - 1 = (remaining nodes to the right)
                dp[i] += dp[left] * dp[i-1 - left];
            }
        }

        return dp[n];
    }
}
