package feb22prep.thirty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L300_LongestIncreasingSubsequence_M {
    public static void main(String[] args) {
        L300_LongestIncreasingSubsequence_M p = new L300_LongestIncreasingSubsequence_M();
        int[] a = {3,4,6};
        System.out.println(p.lengthOfLIS(a));
    }

    public L300_LongestIncreasingSubsequence_M() {
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
