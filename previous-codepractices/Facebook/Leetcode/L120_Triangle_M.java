package Leetcode;

import java.util.List;

public class L120_Triangle_M {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }

        // + 1 for j+1 case for the base case
        int[] dp = new int[triangle.size()+1];

        // each level of integers
        for (int i = triangle.size()-1; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        // first element --> min value
        return dp[0];
    }
}
