package Codebase.dfs;

import common.helpermethods.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L135_CombinationSum {
    public void runTest() {
        int[] c = new int[]{1,2};
        List<List<Integer>> rez = combinationSum(c, 4);
        Helper.printList(rez);

    }

    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    void dfs(int[] candidates,
                int index,
                int remain,
                List<Integer> path,
                List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) { // bottom up approach
            if (candidates[i] > remain) {
                break;
            }

            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            //尤其是这里的方法 你看 remain - candidate[i]相当于回来的时候 选择 i 然后看结果
            dfs(candidates, i, remain - candidates[i], path, result);
            path.remove(path.size() - 1);
        }
    }


//    private void dfs(int[] num, int target, int sum, int index, ArrayList<Integer> path, List<List<Integer>> list ) {
//        // base case
//        if (sum == target) {
//            list.add(new LinkedList<>(path));
//            return;
//        }
//
//        if (sum > target || index >= num.length) {
//            return;
//        }
//
//        int count = 1;
//        int cNum = num[index];
//        while (sum + count * cNum < target) {
//            path.add(num[index]);
//            count++;
//            dfs(num, target, sum, index+1,)
//            dfs(num[]);
//        }
//    }
}
