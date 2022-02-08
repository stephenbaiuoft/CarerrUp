package Prep;

import java.util.Random;

public class L528_RandomPickWeight {

    private int[] weight = null;
    private int sum = 0;
    Random rand = new Random();
    public L528_RandomPickWeight(int[] w) {
        weight = new int[w.length];
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            weight[i] = sum;
        }
    }


    // [w_1, sum{wi}-1] with finding a number
    public int pickIndex() {
        int target = rand.nextInt(sum);
        return binarySearchLowerModified(target);
    }

    private int binarySearchLowerModified(int target) {
        int left = 0;
        int right = weight.length-1;
        //always go left
        while (left < right) {
            int mid = left + (right-left)/2;
            if (target >= weight[mid]) { // 因为按照我们的分布 [0~w1),[w1~w1_w2), ....  所以如果target = w1, 我们应该output index = 1而不是0!
                left = mid + 1; // 这里+1  永远不会出现 infinite loop
            } else { // target < weight[mid]
                right = mid;
            }
        }

        return left;
    }

/* DON'T USE THE TEMPLATE APPROACH USE THE BinarySearch first primary --> keep shortening left for the given condition!!!
    private int binarySearch(int target) {
        int left = 0;
        int right = weight.length-1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (target > weight[mid]) {
                left = mid;
            } else { // target <= weight[mid]
                right = mid;
            }
        }

        // [w1), w1+w2, w1+w2+w3, ...., w1+_____wn-1)]
        if (weight[right] == target)
            return right+1;
        else if  (weight[left] < target) {
            return left;
        } else {
            return left + 1;
        }

    }
*/

}
