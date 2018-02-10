package Microsoft;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the
 * colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color
 red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 */


public class L75_sortColor_M {
    // given this ary and sort this number
    public int[] solution(int[] ary) {
        if( ary == null || ary.length == 0) {
            return ary;
        }

        // p_01, pointing 0 end and increment to next index
        int p_01 = 0;
        int p_2 = ary.length - 1;
        int i = 0;

        while (i <= p_2) {
            if (ary[i] == 0) {
                // put value to ary[i] for now
                ary[i] = ary[p_01];
                ary[p_01] = 0;
                // increment p_01
                p_01 += 1;

            }
            // that case might need to be handled again.. could be 2
            if (ary[i] == 2) {
                // swap
                ary[i] = ary[p_2];
                ary[p_2] = 2;

                p_2 -= 1;
                // change i as the swapped value needs to be changed again
                i -= 1;

            }
            i++;
        }

        return ary;

    }
}
