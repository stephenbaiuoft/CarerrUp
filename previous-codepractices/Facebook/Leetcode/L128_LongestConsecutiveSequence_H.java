package Leetcode;

import java.util.HashMap;

/*
* Idea:
*  Given [100, 4, 200, 1, 3, 2],
*   for 4, 1, 3, 2 each Integer should be of the length of 4!!! in the end
*
* */
public class L128_LongestConsecutiveSequence_H {
    public int longestConsecutive(int[] nums) {
        // base case
        if(nums == null || nums.length == 0) return 0;

        // init variables
        // Integer for nums and the other for Count
        // Idea: keep track of left and right boundary count points
        //       sum them up together
        HashMap<Integer, Integer> map = new HashMap<>();
        int rez = 0;
        for(int i: nums) {
            // if not in map, then
            if(!map.containsKey(i)) {
                int left = map.containsKey(i-1) ? map.get(i-1): 0;
                int right = map.containsKey(i+1) ? map.get(i+1): 0;
                int sum = left + right + 1;
                // update the value for this map
                map.put(i, sum);
                // update max
                rez=  Math.max(rez, sum);
                // we need to update the boundary points ==>
                // ||  <-->  | | to connect pieces

                // left = # of digits to i's left
                // right = # of digits to i's right
                map.put(i - left, sum);
                map.put(i + right, sum);
            }
        }
        return rez;

    }
}
