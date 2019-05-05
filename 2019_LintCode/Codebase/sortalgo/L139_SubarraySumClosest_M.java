package Codebase.sortalgo;

import java.util.Arrays;

public class L139_SubarraySumClosest_M {
    public void runTest() {
        int[] input = new int[] {-3,1,1,-3,5};
        subarraySumClosest(input);
    }

    class Pair {
        int sum, index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length < 1) return new int[] {0,0};
        // write your code here
        Pair[] sumSet = new Pair[nums.length+1];
        sumSet[0] = new Pair(0,0);
        int[] rez = new int[2];
        int minDelta = Integer.MAX_VALUE;
        int cDelta = 0;

        int sum = 0;
        for (int i= 1; i <=nums.length;i++) { // start from 1 as 0 is our offset
            sum+=nums[i-1];
            sumSet[i] = new Pair(sum, i); // save to to sumSet
        }

        // sort in increasing order
        Arrays.sort(sumSet, (p1, p2) -> p1.sum - p2.sum);

        for(int i = 1; i < sumSet.length; i++) {
            cDelta = sumSet[i].sum - sumSet[i-1].sum;
            if (cDelta < minDelta) {
                minDelta = cDelta; // update
                // copy the new min
                int[]tmp = new int[]{sumSet[i].index-1, sumSet[i-1].index-1};
                Arrays.sort(tmp);
                rez[0] = tmp[0]+1;
                rez[1] = tmp[1];
            }
        }

        return rez;
    }
}
