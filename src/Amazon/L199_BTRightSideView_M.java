package Amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
    1            <---
  /  \
 2    3         <---
 \    \
 5    4       <---
 You should return [1, 3, 4].

        1
       /  |
      2   3
     /
    4

    ===> [1, 3, 4]
 */


public class L199_BTRightSideView_M {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        goRight(root, 1, result);

        return result;
    }

    private void goRight(TreeNode node, int height, List<Integer> result ) {
        if (node == null) return;
        // selectively add!!!! by introducing a variable!
        if( height > result.size()){
            result.add(node.val);
        }

        // i think right will create and add all the possible height
        goRight(node.right, height +1, result);
        goRight(node.left, height +1 , result);
    }
}
