package Leetcode;

/*
*
    Given a binary tree, count the number of uni-value subtrees.

    A Uni-value subtree means all nodes of the subtree have the same value.

    Example :

    Input:  root = [5,1,5,5,5,null,5]

                  5
                 / \
                1   5
               / \   \
              5   5   5

    Output: 4
* */


public class L250_M {

    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        checkUni(root);
        return count;
    }

    // check whether node (including this one) is a subtree of univalue
    private boolean checkUni(TreeNode node) {
        // base case
        if (node == null) return true;
        boolean left = checkUni(node.left);
        boolean right = checkUni(node.right);
        // both left & right
        if (left && right) {
            // 4 types of cases together
            /* THESE ARE THE FOLLOWING!!!
                   a             a             a              a
               null  null      null a        a  null        a   a
            */

            if ( ((node.left == null) || (node.left.val == node.val)) &&
                    (node.right == null || (node.right.val == node.val))
                    )
            {
                count ++;
                return true;
            }

        }

        return false;
    }

// The following is the one without global variable!!!!!!!!!!!!!
    public int countUnivalSubtrees2(TreeNode root) {
        // defaults to 0
        int[] valSet = new int[1];
        getUni(root, valSet);

        return valSet[0];
    }

    // check whether node is uniTree, and increment valSet -> java by reference
    private boolean getUni(TreeNode node, int[] valSet) {
        // base case
        if (node == null) return true;

        boolean left = getUni(node.left, valSet);
        boolean right = getUni(node.right, valSet);

        // case 4 types
        if (left && right) {
            if ((node.left == null || node.left.val == node.val) &&
                    (node.right == null || node.right.val == node.val)) {
                valSet[0] ++;
                return true;
            }
        }

        return false;
    }
}
