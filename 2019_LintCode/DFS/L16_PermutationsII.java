package DFS;

import java.util.*;

public class L16_PermutationsII {
    public L16_PermutationsII() {
        int[] nums = new int[] {1,1};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

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
            // for this level, nums[i-1] the first one would have been chosen, and we can safely skip the remaining identical ones
            // 这里很重要 相当于在这一层你不用再选相同的元素了！！！
            if (i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
                // !visited【i-1】重要 --> 因为 如果visited[i-1]的话 我们不能skip 应该
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
