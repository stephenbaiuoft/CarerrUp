package min_max;

import java.util.HashMap;

/*
* Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.

* */

// 很经典的min max的题目
public class L486_PredictTheWinner_M {
    public boolean PredictTheWinner(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return getMax(0, nums.length-1, nums, map) >= 0;
    }

    // gives the maximum you can get given [left, right] range for nums
    private int getMax(int left, int right, int[] nums, HashMap<Integer, Integer> map) {
        if (left == right) {
            return nums[left];
        }

        int k = left * nums.length + right; // hashing trick
        if (map.containsKey(k)) {
            // maximum you can get from [left, right] range
            return map.get(k);
        }
        // now we need to compute
        int rez = Math.max(
                nums[left] - getMax(left+1, right, nums, map),
                nums[right] - getMax(left, right-1, nums, map));

        map.put(k, rez);
        return rez;
    }
}
