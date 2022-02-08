package Amazon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *Given a sorted array, two integers k and x,
 * find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 Note:
 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104
 *
 *                  TEST
 *          L658_KCloestElements_M program = new L658_KCloestElements_M();

                 List<Integer> ary = new LinkedList<>();
                 ary.add(1);
                 ary.add(2);
                 ary.add(3);
                 ary.add(4);
                 ary.add(5);
                 program.findClosestElements(ary, 4, 3 );
 */

public class L658_KCloestElements_M {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        if(k >= arr.size()) {
            return arr;
        }
        // create abs ary
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        List<Integer> result = new LinkedList<>();

        int[] abs = new int[arr.size()];
        for(int i = 0; i < abs.length; i++){
            int tmp = Math.abs( arr.get(i) - x );
            if (tmp < min) {
                min = tmp;
                minIndex = i;
            }
            abs[i] = tmp;
        }

        result.add(arr.get(minIndex));
        int left = minIndex - 1;
        int right = minIndex + 1;
        int length = abs.length;
        int count = k - 1;

        while(count > 0) {
            // check sanity
            if(right < length && left >= 0 ) {
                if(abs[left] <= abs[right]) {
                    result.add(arr.get(left));
                    left --;
                } else{
                    result.add(arr.get(right));
                    right++;
                }
            }
            else {
                //right out of bound!
                if(right >= length) {
                    result.add(arr.get(left));
                    left --;
                } else {
                    result.add(arr.get(right));
                    right ++;
                }

            }
            count --;
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o1 - o2;
            }
        });
        return result;
    }
}
