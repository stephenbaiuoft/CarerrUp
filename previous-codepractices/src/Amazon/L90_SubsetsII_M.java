package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
/**
 *
 public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
 }

 private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
    if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
 }
 */


public class L90_SubsetsII_M {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        backTrack(nums, 0, list, new ArrayList<>());

        for(List solution: list) {
            System.out.println( Arrays.toString(solution.toArray())
                     );
        }

        return list;
    }

    private void backTrack(int[] nums, int index,List<List<Integer>> solutionSet,
                           ArrayList<Integer> solution ) {

        solutionSet.add(new ArrayList<>(solution));
        for (int i = index; i < nums.length; i++) {
            if( i > index && nums[i] == nums[i - 1])  continue;
            solution.add(nums[i]);
            backTrack(nums, i + 1, solutionSet, solution);
            solution.remove(solution.size()-1);
        }
    }

}

