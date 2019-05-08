package Codebase.binarysearch;

public class L617_MaxAverageSubarrayII_M {
    public void runTest() {
        double v = maxAverage(new int[]{1,12,-5,-6,50,3}, 3);
        System.out.println(v);
    }
    // whehter you can find such an average
    // return true is possible in A with K subarray
    // @ the same time, update A array
    private boolean canFind(int[] A, int K, double maxAvg) {
        int i;
        double curSum = 0; // sum add to right
        double leftStartSum = 0, minLeftSum = 0; // sum from 0 starting
        for (i = 0; i < K; i++) { // first
            curSum += A[i] - maxAvg;
        }

        for (i = K; i <= A.length; i++) {
            if (curSum - minLeftSum >= 0) {
                return true;
            }

            if (i < A.length) {
                curSum += A[i] - maxAvg;
                leftStartSum += A[i - K] - maxAvg;
                // keep the minLeftSum always because this says there exists for j s.t starting from it would max out the average
                minLeftSum = Math.min(minLeftSum, leftStartSum);
            }
        }

        return false;
    }

    public double maxAverage(int[] A, int K) {
        int i;
        double start, stop, mid;
        start = stop = A[0];
        for (i = 0; i < A.length; ++i) {
            start = Math.min(A[i], start);
            stop = Math.max(A[i], stop);
        }

        while (start < stop) {
            mid = (start + stop) / 2;
            if (canFind(A, K, mid)) {
                start = mid;
            }
            else {
                stop = mid;
            }
        }

        return start;
    }
}
