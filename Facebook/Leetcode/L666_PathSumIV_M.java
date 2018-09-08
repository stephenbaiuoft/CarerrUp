package Leetcode;

/*
*
    If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

    For each integer in this list:
    The hundreds digit represents the depth D of this node, 1 <= D <= 4.
    The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
    The units digit represents the value V of this node, 0 <= V <= 9.
    Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

    Example 1:
    Input: [113, 215, 221]
    Output: 12
    Explanation:
    The tree that the list represents is:
        3
       / \
      5   1

    The path sum is (3 + 5) + (3 + 1) = 12.
    Example 2:
    Input: [113, 221]
    Output: 4
    Explanation:
    The tree that the list represents is:
        3
         \
          1

    The path sum is (3 + 1) = 4.
* */

/*
* By sorting the array and traversing it in descending order,
* we are actually doing a level traversal from the bottom to the top,
* with each level from the right to the left. For each node, propogate the number of leaves that node has to its parent.
* After the loop, we know how many leaves each node leads to,
* which is also the number of times that node will be included in a path.
* */
public class L666_PathSumIV_M {

    public int pathSum(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[][] leaves = new int[5][9];
        int sum = 0;

        // assuming nums is sorted
        for (int i = nums.length -1; i > -1; i--) {
            int d = nums[i] / 100;
            int p = nums[i] / 10 % 10;
            int val = nums[i] % 10;
            if (leaves[d][p] == 0) leaves[d][p] = 1;
            // brilliant! update the value for this particular node's parent
            leaves[d-1][(p+1)/2] += leaves[d][p];

            sum += val * leaves[d][p];
        }

        return sum;
    }
}
