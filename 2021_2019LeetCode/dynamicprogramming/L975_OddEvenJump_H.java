package dynamicprogramming;

/*
*
*
You are given an integer array A.  From some starting index,
 you can make a series of jumps.  The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps,
  and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.

You may from index i jump forward to index j (with i < j) in the following way:

During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
(It may be the case that for some index i, there are no legal jumps.)
A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)

Return the number of good starting indexes.


Example 1:

Input: [10,13,12,14,15]
Output: 2
Explanation:
From starting index i = 0, we can jump to i = 2 (since A[2] is the smallest among A[1], A[2], A[3], A[4] that is greater or equal to A[0]), then we can't jump any more.
From starting index i = 1 and i = 2, we can jump to i = 3, then we can't jump any more.
From starting index i = 3, we can jump to i = 4, so we've reached the end.
From starting index i = 4, we've reached the end already.
In total, there are 2 different starting indexes (i = 3, i = 4) where we can reach the end with some number of jumps.

*
* */


import java.util.Map;
import java.util.TreeMap;

public class L975_OddEvenJump_H {

    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return 0;
        // DP[i][0] ==> odd index, jump up
        // DP[j][1] ==> even index, jump down
        boolean[][] dp = new boolean[A.length][2];
        // mJump <i, j>: store the minimum index that i index can jump to
        // and init the set
        TreeMap<Integer, Integer> mJump = new TreeMap<>();
        mJump.put(A[A.length-1], A.length-1);

        // init condition
        dp[A.length-1][0] = true;
        dp[A.length-1][1] = true;

        // 从最后第二个开始， 到第一个 我们开始归纳动态规划法则
        // 每一个i index， 归纳2种情况 jumpUp 和 jumpDown
        for (int i = A.length-2; i > -1; i--) {
            Map.Entry<Integer, Integer> entry = null;
            entry = mJump.ceilingEntry(A[i]);
            if (entry != null) {
                int iJumpUpToJ = entry.getValue();
                dp[i][0] = dp[iJumpUpToJ][1]; // in DP[j][1] meaning j is jumping down, and j > i
            }

            entry = mJump.floorEntry(A[i]);
            if (entry != null) {
                int iJumpDownToK = entry.getValue();
                dp[i][1] = dp[iJumpDownToK][0]; // in DP[k][0] --> meaning k is jumping up, and k > i
            }
            // update the mJump before returning
            // i is definitely smaller, so A[i] matching would always update to smaller i
            mJump.put(A[i], i);
        }

        // 因为只有jump up才算是valid 所以我们把 sum {DP[i][0]} where DP[i][0] == true
        int tot = 0;
        for (int i = 0; i < A.length; i++) {
            if ( dp[i][0] == true) {
                tot += 1;
            }
        }

        return tot;
    }
    
}
