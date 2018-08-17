package May;

import java.util.LinkedList;
import java.util.List;

public class L228_SummaryRange_M {
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
