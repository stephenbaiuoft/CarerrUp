package feb22prep.thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L354_RussianDE_H {
    public static void main(String[] args) {

    }

    /**
     * so to take a step back, basically we are reducing this problem from a 2 dimensional problem into a single
     * array problem because we know how to solve a single array longest increasing subsequence in N Log N time.
     * So with that said how do we reduce it?
     * Well we can sort it by the first dimension because if it's smaller then the next it is good to go for the LIS problem.
     * But what if they are equal? Well that's a problem because they cannot be equal otherwise the first condition fails as the width of the envelope must be greater
     * than not just equal to the other width of the envelope.
     * So to fix that if they are equal we can just sort in descending order
     *  -> because that will not pass the LIS algorithm so it wont count it in the longest increasing subsequence.
     */

    public int maxEnvelopes(int[][] envelopes) {
        // Sort, small -> large width, if same width, then we will sort higher length first,
        // so that in the sub problem same length ==> LIS will not count it
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                // Decreasing order with o2
                return o2[1] - o1[1];
            } else {
                // Increasing order
                return o1[0] - o2[0];
            }
        });

        int[] lengthArray = new int[envelopes.length];
        for (int i = 0; i < lengthArray.length; i++ ) {
            // Get the height
            lengthArray[i] = envelopes[i][1];
        }

        return lengthOfLIS(lengthArray);

    }

    public int lengthOfLIS(int[] nums) {
        // Idea is we have a sorted list to store current LIS
        // Then for the next incoming number, we will insert it onto the LIS
        /**
         * One thing to add: this algorithm does not always generate a valid subsequence of the input,
         * but the length of the subsequence will always equal the length of the longest increasing subsequence
         *
         * 但是这个Key是什么 是你swap的时候 这个sequence的length 永远是正确的！！ 因为i你换的是比当前要小的
         * 所以之后遇到更大的， 这个小的数字 也不会改变这个array的length！！！！！！！
         *
         * 那么优化 可以用BFS 来实现LogN 的insert！！！！
         *
         */

        // Easier to insert
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            // Case where num can added, list end is always the largest so far
            if (list.isEmpty() || list.get(list.size()-1) < num) {
                list.add(num);
            } else { // num <= head
                int index = binarySearch(list, num);
                // update
                list.set(index, num);

            }
        }
        return list.size();
    }

    // try to find the index to insert num, where index is closest to num
    public int binarySearch(List<Integer> list, int num) {
        int l = 0;
        int r = list.size()-1;
        int mid;
        while (l < r) {
            mid = l + (r-l)/2;
            if (list.get(mid) < num) { // mid + 1 可能和num比 因为 binarySearch的时候 以及知道 num <= head
                l = mid + 1;
            } else { // list.get(mid) >= num
                r = mid;
            }
        }

        return r;
    }

}
