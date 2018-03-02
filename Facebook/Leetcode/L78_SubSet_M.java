package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class L78_SubSet_M {
    public List<List<Integer>> rez = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return rez;
        }

        List<Integer> l = new LinkedList<>();
        helper(nums, 0, l);
        return rez;

    }
    // nums => [1,2]
    public void helper(int[] nums, int i, List<Integer> l) {
        if (i == nums.length) {
            rez.add(new LinkedList<>(l));
        }
        else {
            List tmp_no = new LinkedList<>(l);
            List tmp_yes = new LinkedList<>(l);

            // each time you may add to list
            helper(nums, i+1, tmp_no);
            // or not add to list
            tmp_yes.add(nums[i]);
            helper(nums, i+1, tmp_yes);
        }
    }
}
