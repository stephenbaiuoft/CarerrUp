package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L46_Permutation_M {

    public List<List<Integer>> rez = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return rez;
        }
        // # of digits required
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums, list, n);

        return rez;
    }

    public void permuteHelper(int[] nums, List<Integer> list, int n) {
        if (list.size() == n) {
            // adding new list to rez
            rez.add(new ArrayList<>(list));
        } else{
            for(Integer i: nums) {
                // choose!!!!
                if (!list.contains((Integer) i)) {
                    list.add(i) ;
                    // explore
                    permuteHelper(nums, list, n);

                    // unchoose --> remove the last element
                    list.remove(list.size()-1);
                }
            }

        }
    }
}
