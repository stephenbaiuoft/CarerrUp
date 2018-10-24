package tree_traversal;

import common.data.types.Node;
import common.data.types.TreeNode;

/*
* Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
* */
/* 思路
*  v(right), v(left), node traversal order:
*   6, 5, 4, 3, 2 , 1
*
* */

public class L114_Flattern_M {

    // prev keeps track of
    private TreeNode prev = null;
    // flattern order is preOrder
    // recursion order --> node, v(left), v(right)
    // given the example will be: 1, 2, 3, 4, 5, 6

    // recursion reverse order => v(right), v(left), node! (很重要)
    // given the example will be -> 6, 5, 4, 3, 2, 1

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        // update prev node
        prev = root;
    }

}
