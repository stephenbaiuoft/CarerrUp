package ByMonth.august.May;

import java.util.Arrays;

public class L164_MaxGap_H {
    public L164_MaxGap_H() {
        int[] input = new int[] {1,2,3,100};
        int rez = maximumGapSol(input);
    }

    public int maximumGapSol(int[] num) {
        if (num == null || num.length < 2)
            return 0;
        // get the max and min value of the array
        int min = num[0];
        int max = num[0];
        for (int i:num) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // the minimum possibale gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
        int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
        int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        // put numbers into buckets
        for (int i:num) {
            if (i == min || i == max)
                continue;
            int idx = (i - min) / gap; // index of the right position in the buckets
            bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
            bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
        }
        // scan the buckets for the max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < num.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
                // empty bucket
                continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            // update previous bucket value
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }

    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        else if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // get the smallest and largest element
        for(int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        // gap is the minimum gap (and each bucket would be inclusive then)
        int delta = max - min;
        int gap = delta/(nums.length - 1);
        gap +=1;

        // assign nums.length - 1 number of buckets
        int[] minBucket = new int[nums.length -1];
        int[] maxBucket = new int[nums.length -1];
        // keep track
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        // now we use division to determine which bucket the number falls under
        int index = 0;

        for(int n: nums) {
            index = (n - min)/gap;
            minBucket[index] = Math.min(minBucket[index], n);
            maxBucket[index] = Math.max(maxBucket[index], n);
        }

        int maxGap = 0;
        int prev = maxBucket[0];
        // loop through nums.length - 1 buckets
        for(int i = 1; i < nums.length - 1; i ++) {
            // empty bucket (because of our initial setting)
            if(minBucket[i] > maxBucket[i] ) {
                continue;
            }
            maxGap = Math.max(maxGap, minBucket[i] - prev);
            prev = maxBucket[i];
        }

        return maxGap;
    }
}
