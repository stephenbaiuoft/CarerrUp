package Amazon.OA2Review;

import java.util.HashSet;

/**
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
    5
   / \
  3   6
 / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
    5
   / \
  3   6
 / \   \
 2   4   7

 Target = 28

 Output: False
 */

public class L653_TwoSumBST_E {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {
        // idea: use hashSet to find if there's any match
        HashSet<Integer> counterPart = new HashSet<>();

        boolean contain = iterate(root, k, counterPart);
        return contain;
    }

    private boolean iterate(TreeNode node, int k, HashSet<Integer> counterPart) {
        if(node == null) {
            return false;
        } else {
            if(counterPart.contains(node.val)) {
                return true;
            }

            counterPart.add(k - node.val);
            // or relationship
            return iterate(node.left, k, counterPart) || iterate(node.right, k, counterPart);
        }
    }

}
