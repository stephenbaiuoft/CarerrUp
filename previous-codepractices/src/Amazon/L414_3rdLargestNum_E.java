package Amazon;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.
 */

// build a minHeap of size 3
public class L414_3rdLargestNum_E {
    // faster solution
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
//    public int thirdMax(int[] nums) {
//        // ascending order, meaning smallest at the top
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
//        Set<Integer> set = new HashSet<>();
//
//        for( int num : nums){
//            if(!set.contains(num)) {
//                if(minHeap.size() < 3) {
//                    // minHeap.peek() meaning we do not want duplicates
//                    minHeap.add(num);
//                } else{
//                    // minHeap size is 3
//                    if (num > minHeap.peek()){
//                        minHeap.poll();
//                        minHeap.add(num);
//                    }
//                }
//            }
//            set.add(num);
//        }
//
//        if(minHeap.size() < 3){
//            // remove first
//            int max = 0;
//            while(minHeap.peek()!=null){
//                max = minHeap.poll();
//            }
//            return max;
//        }
//
//        // case the 3rd largest
//        return minHeap.poll();
//    }
}
