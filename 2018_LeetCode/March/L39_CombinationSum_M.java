package March;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L39_CombinationSum_M {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<List<Integer>> rez = new LinkedList<>();
        if(candidates == null) return rez;

        // sort candidates in increasing order first
        Arrays.sort(candidates);
        helper(candidates, 0, target, rez, list);

        return rez;
    }

    // start index
    public void helper(int[] candidates, int start, int target,
                       List<List<Integer>> rez, LinkedList<Integer> list) {
        // loop through the list
        int remain = 0;
        for(int i = start; i < candidates.length; i++) {
            // Choose
            list.add(candidates[i]);

            // Explore
            remain = target - candidates[i];
            if(remain == 0) {
                rez.add(new LinkedList<>(list));
                // remove the last
                list.removeLast();
                // return
                return;
            }
            else if(remain > 0) {
                // do the next iteration
                helper(candidates, i, remain, rez, list);
            }
            // else --> return as remain is negative
            else {
                // unchose
                list.removeLast();
                return;
            }
            // Unchose
            list.removeLast();
        }

    }
}
