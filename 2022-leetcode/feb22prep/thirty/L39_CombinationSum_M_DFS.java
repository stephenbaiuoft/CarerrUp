package feb22prep.thirty;

import java.util.*;

public class L39_CombinationSum_M_DFS {
    public static void main(String[] args) {

    }

    public L39_CombinationSum_M_DFS() {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();

        dfs(candidates, 0, target, new LinkedList<>(), result);

        return result;
    }

    public void dfs(int[] candidates, int curIndex, int target, LinkedList<Integer> curList, List<List<Integer>> result) {
        // base condition
        if (curIndex >= candidates.length) return;
        if (target < 0) return;
        if (target == 0) {
            // We found one, create a new linkedlist, and add to result
            result.add(new LinkedList<>(curList));
            return;
        }

        // Choose
        for (int i = curIndex; i < candidates.length; i++) {
            curList.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], curList, result);
            curList.removeLast();
        }

    }
}
