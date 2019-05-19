package Codebase.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_Permutations {
    public List<List<Integer>> permute(int[] nums) {
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

            permutation.add(nums[i]);
            visited[i] = true;
            dfsAll(nums, visited, permutation, result);

            visited[i] = false;
            permutation.remove(permutation.size()-1);
        }

    }
}
