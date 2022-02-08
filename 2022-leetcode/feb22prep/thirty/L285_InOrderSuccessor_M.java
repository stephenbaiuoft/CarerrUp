package feb22prep.thirty;

import java.util.Stack;

public class L285_InOrderSuccessor_M {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode inorderSuccessorIteartive(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                // p.val < root.val  root can be the successor
                // Keep track of the root first
                // Update successor ONLY HAPPENS when --> You move the left!!!, if move to right, successor NOT UPDATED!!!
                successor = root;
                // Go left once
                root = root.left;
            }
        }

        return successor;
    }


    public TreeNode inorderSuccessorStack(TreeNode root, TreeNode p) {
        // L, node, R
        // 2 while loops, 1 stack
        if (root == null || p == null) return null;
        Stack<TreeNode> s = new Stack<>();

        TreeNode cur = root;
        TreeNode tmp;
        Boolean isFound = false;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            // cur is null, so re-assign it
            cur = s.pop();
            if (isFound) {
                // this is se
                return cur;
            }
            if (cur == p) {
                isFound = true;
            }

            // Go right
            cur = cur.right;
        }

        return null;

    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Base case --> null node
        // reaching null, return null
        if(root == null) return null;

        else if (root.val <= p.val) {
            // must be in root right subtree

            // because a node successor in InOrder will always be in it's right subtree!!!
            return inorderSuccessor(root.right, p);
        }
        // Case where root.val > p.val, so the root needs to be considered as well
        else {
            // Get the the subTree left first
            // Always go left --> when this is smaller, this is the right order to find p
            TreeNode left = inorderSuccessor(root.left, p);

            // need to return the root where the first null is hit
            // when backtracking to this level, this will be
            // the node
            if (left == null) {
                // case where the parent is being returned
                return root;
            }
            else {
                // now as for others return the left, which is the parent node
                return left;
            }
        }
    }

}
