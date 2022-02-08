package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */

/**
 * Classic Backtracing Problem! ==> Must provide the data
 * 6  steps
 * 1. reject
 * 2. accept + 3. output
 * 4. first piece
 * 5. next piece
 * 6. root(piece) (think of it as initial piece)
 */


public class L78_Subsets_M {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutionSet = new LinkedList<>();
        LinkedList<Integer> solution = new LinkedList<>();
        backTrack(nums, 0, solutionSet, solution);

        return solutionSet;

    }

    private void backTrack(int[] nums, int index, List<List<Integer>> solutionSet,
                           LinkedList<Integer> solution) {
        // given the question wants all combinations ==> really there's no reject state
        solutionSet.add(new LinkedList<>(solution));
        for(int i = index; i < nums.length; i++){
            //first piece
            solution.add(nums[i]);
            // now pass to backTrack SortAlgo to continue build on previous pieces!!
            backTrack(nums, i + 1, solutionSet, solution);
            // the alternative first piece
            solution.removeLast();
        }

    }
}
