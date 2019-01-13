package sliding_windows;

import java.util.LinkedList;
import java.util.List;
/*
*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*
* */

/**
 * 思路： 主要还是看题目
 */


public class L228_SummaryRanges_M {
    public List<String> summaryRanges(int[] nums) {
        List<String> rez = new LinkedList<>();
        if(nums == null || nums.length ==0) return rez;

        int prev = nums[0];
        int start = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev + 1) {
                // update prev
                prev = nums[i];
            }

            else {
                if (prev - start > 0) {
                    String tmp = String.valueOf(start)  + "->" + String.valueOf(prev) ;
                    rez.add(tmp);
                }
                else {
                    // 1 value only
                    rez.add(String.valueOf(start));
                }

                // a new start
                start = nums[i];
                prev = nums[i];
            }
        }
        // for last sequence
        if (prev - start > 0) {
            String tmp = String.valueOf(start)  + "->" + String.valueOf(prev) ;
            rez.add(tmp);
        }
        else {
            // 1 value only
            rez.add(String.valueOf(start));
        }
        return rez;
    }
}
