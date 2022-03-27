package dp;

/*
Available: https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/

* Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
* */

/*
* 注意 这个意识2 x N 的array！！！
* */
public class MaxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        if (A == null || A.length < 1 || A[0].length < 1) return 0;

        // 注意起点
        int include = Math.max(A[0][0], A[1][0]);
        int exclude = 0, new_exclude = 0;

        for (int i = 1; i < A[0].length; i++) {
            new_exclude = Math.max(include, exclude);

            // update the include value for this particular index i
            include = exclude + Math.max(A[i][0], A[i][1]);

            // update new_exclude
            exclude = new_exclude;
        }

        return Math.max(include, exclude);
    }
}

