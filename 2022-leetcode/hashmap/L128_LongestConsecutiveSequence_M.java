package hashmap;

import java.util.HashMap;
import java.util.Map;

public class L128_LongestConsecutiveSequence_M {
    /**
     * 要求是 O(n)
     *
     * 用hashmap来存 一个num 它目前最大的longest sequence是多少
     *
     * 这个sequence怎么计算？
     * 每次获得一个number
     * - 查询左边 右边是否有number存在 （left = num -1, right = num + 1)
     * - 没有就是0， 有就读取值
     * 然后算上这个num 最长 left + 1 + right!!!!
     *
     * 这样把num， num边界的最左边能够到的  最右边能够到的 都更新位 left + 1 + right!!!!
     *
     * 这样只要你 需要链接 一定是
     * - 没见过的num 而且 一定是在边界那
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // each number, max consecutive at its left, right boundary
        Map<Integer, Integer> numMax = new HashMap<>();
        int longest = 0;
        for (int num: nums) {
            // only if it's a new value
            if (!numMax.containsKey(num)) {
                int left = numMax.getOrDefault(num-1, 0);
                int right = numMax.getOrDefault(num+1, 0);

                // found one, we can at least increase by 1
                int consecutive = left + 1 + right;
                longest = Math.max(longest, consecutive);

                numMax.put(num, consecutive);
                // update boundary numbers
                // n = 5, left = 1, then num-1 = 4 (is the boundary)
                numMax.put(num - left, consecutive);
                numMax.put(num + right, consecutive);
            }

        }

        return longest;
    }
}
