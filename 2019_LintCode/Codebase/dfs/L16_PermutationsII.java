package Codebase.dfs;

import java.util.*;

public class L16_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        dfsAll(nums, new boolean[nums.length],
                new ArrayList<>(),result);

        return result;
    }

    private void dfsAll(int[] nums, boolean[] visited,
                        List<Integer> permutation,
                        List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        // explore every possible start index
        // every recursion -> always from index i from [0 to nums.length)
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // duplicates like 2_1st, 2_2nd, 1
            //              vs 2_2nd, 2_1st, 1
            if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfsAll(nums, visited, permutation, result);

            visited[i] = false;
            permutation.remove(permutation.size()-1);
        }

    }
}
