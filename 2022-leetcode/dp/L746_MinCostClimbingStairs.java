package dp;

public class L746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length ==0) return 0;

        int[] minCost = new int[cost.length+1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(minCost[i-1] + cost[i-1], minCost[i-2] + cost[i-2]);
        }

        return minCost[cost.length];

    }

    public int minCostClimbingStairsO1(int[] cost) {
        if (cost == null || cost.length == 0) return 0;

        int n = cost.length;
        // dpS1, dpS2 and min (interchangable due to the dp points)

        // 1, 2, ...,   dpS2, dpS1, min, n_to_be_computed
        // Now move everything by 1
        // 1, 2, ..., noCare, dpS2_from_dpS1, dpS1_from_min, min_new, n+1_to_be_computed
        int dpS1=0;
        int dpS2=0;
        int min = 0;
        // i starts @ the 2nd index, index 0 or index 1
        // s2, s1, min
        for (int i = 2; i <= n; i++ ) {
            min = Math.min(dpS1 + cost[i-1],
                    dpS2 + cost[i-2]
            );
            dpS2= dpS1;
            dpS1 = min;
        }

        return min;
    }
}
