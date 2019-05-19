package Codebase.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// power set all combination possibilities --> important!
public class L18_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }


    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // base case -> regardless add in the combinations
        result.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue; // skip duplicate copies
            }

            subset.add(nums[i]);
            dfs(nums, i+1, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
