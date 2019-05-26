package Codebase.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L153_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        if (num == null) return null;

        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<>();
        dfs(num, target, 0, 0, new ArrayList<>(),list);

        return list;
    }

    private void dfs(int[] num, int target, int sum, int index, ArrayList<Integer> path, List<List<Integer>> list ) {
        // base case
        if (sum == target) {
            list.add(new LinkedList<>(path));
            return;
        }

        if (sum > target || index >= num.length) {
            return;
        }

        for (int i = index; i < num.length; i++) {
            if (i > index && num[i]==num[i-1]) { // i > index --> not the same as the previous parent index
                continue; // skip this entry
            }

            path.add(num[i]);
            dfs(num, target, sum + num[i], i+1, path, list);
            path.remove(path.size()-1); // remove last element
        }
    }
}
