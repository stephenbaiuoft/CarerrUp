package GA;

import java.util.List;

public class Q2 {
    // Complete the MinSliceWeight function below.
    // Complete the MinSliceWeight function below.
    public static int minSliceWeight(List<List<Integer>> Matrix) {
        //DP solution
        //assuming the input is N X N
        // base case
        if (Matrix == null || Matrix.size() < 1) return 0;

        // DP to store values
        int n = Matrix.size();
        if (n == 1) {
            return Matrix.get(0).get(0) ;
        }


        long[] dp_prev = new long[n];
        // base case
        for (int col = 0; col < n; col++) {
            dp_prev[col] = Matrix.get(0).get(col);
        }

        for(int row = 1; row < n; row++) {
            long[] dp_cur = new long[n];
            // check boundary condition
            // reverse order
            dp_cur[0] = Matrix.get(row).get(0) + Math.min(dp_prev[0], dp_prev[1]) ;
            dp_cur[n-1] = Matrix.get(row).get(n-1) + Math.min(dp_prev[n-1], dp_prev[n-2]);

            for (int col = 1; col < n -1 ; col++) {
                long minVal = Integer.MAX_VALUE ;
                minVal = Math.min(dp_prev[col], dp_prev[col-1]) ;
                minVal = Math.min(minVal, dp_prev[col+1]) ;
                dp_cur[col] = Matrix.get(row).get(col) + minVal;
            }
            // replace the dp_prev
            dp_prev = dp_cur ;
        }

        long rez = dp_prev[0];
        for (int col = 1; col < n; col++) {
            rez = Math.min(dp_prev[col], rez) ;
        }

        return (int) rez;
    }


}


