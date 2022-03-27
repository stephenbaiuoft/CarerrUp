package tree.traversal;

import common.data.types.TreeNode;

/*
* Given a binary Tree, flatten it to a linked list in-place.

For example, given the following Tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened Tree should look like:

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
    // SortAlgo order --> node, v(left), v(right)
    // given the example will be: 1, 2, 3, 4, 5, 6

    // SortAlgo reverse order => v(right), v(left), node! (很重要)
    // given the example will be -> 6, 5, 4, 3, 2, 1

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);

        // At this point in recursion, before exit right
        root.right = prev;
        root.left = null;

        // update prev node
        prev = root;
    }


    // Recursion thinking of what you need
    // Define a function called flatten
    // Let's say it will flatten the node and its children in preOrder as expected
    // Then given a node, you'd have
    // flatten(node.left), flatten(node.right) which sorts the left and the right subtrees respectfully
    // Now, given the node itself, what are the node information you need?????
    // You need the tail node from the left subtree, as well as the tail node right the right subtree(this is because at the node recursion back out, you'd need to return left subtree last node VS right subtree last node)
    //  - Now given it's preOrder, you SHOULD DO
    //  - leftTail.right = node.right
    //  - node.right = node.left
    //  - node.left = null
    //  - NOW IMPORTANT!!!!! WHEN YOU'VE REARRANGE the Node, LeftSubTree, RightSubTree, what should you return????
    //   - LeftTail or the RightTail??? what if RightTail is null??????


    // 最重要 base condition？？？ 哪些情况 可以直接return 不需要 sort 对吧？
    // Node  == null?? return Null
    // Node is a leaf??? return Node

    public void flattenRecursion(TreeNode root) {
        flatternNode(root);
    }

    // recursion method that flatterns node
    public TreeNode flatternNode(TreeNode node) {
        // Base conditions
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode left = flatternNode(node.left);
        TreeNode right = flatternNode(node.right);

        // left is not null??????????
        if (left != null) {
            // 这个情况 只存在于 leftTail有东西 （意味着有LeftTree）
            left.right = node.right;
            node.right = node.left;
            node.left = null;
        }


        // return right as right is the furthermost
        return right == null? left: right;
    }

}
